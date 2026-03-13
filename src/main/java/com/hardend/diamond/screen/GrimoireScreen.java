package com.hardend.diamond.screen;

import com.hardend.diamond.data.PowerData;
import com.hardend.diamond.data.PowerData.PowerEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class GrimoireScreen extends Screen {
    private static final int W=330, H=220, PAD=10, ROW_H=11, MAX_ROWS=13;
    private static final int C_BG=0xEE060615, C_BORDER=0xFF3A6FFF, C_TITLE=0xFFD4AF37;
    private static final int C_SEL=0xFF162250, C_PASSIVE=0xFF7EC8E3, C_ACTIVE=0xFFFFD700;
    private static final int C_ULTIMATE=0xFFFF6030, C_BIND=0xFF90EE90, C_DESC=0xFFCCCCCC, C_DIM=0xFF666688;

    private EditBox searchField;
    private List<PowerEntry> results;
    private int selectedIdx=0, scroll=0;

    public GrimoireScreen() {
        super(Component.literal("Grimoire of Powers"));
        results = PowerData.getAll();
    }

    @Override
    protected void init() {
        int x=(width-W)/2, y=(height-H)/2;
        searchField = new EditBox(font, x+PAD, y+PAD+14, W/2-PAD*2, 14, Component.literal("Zoeken…"));
        searchField.setMaxLength(64);
        searchField.setHint(Component.literal("Typ power, item of type…").withStyle(ChatFormatting.DARK_GRAY));
        searchField.setResponder(q -> { results=PowerData.search(q); selectedIdx=0; scroll=0; });
        searchField.setFocused(true);
        addRenderableWidget(searchField);
        setInitialFocus(searchField);
    }

    @Override
    public boolean keyPressed(int key, int scan, int mods) {
        if (key==256) { onClose(); return true; }
        if (key==264 && selectedIdx<results.size()-1) { selectedIdx++; if(selectedIdx>=scroll+MAX_ROWS) scroll++; return true; }
        if (key==265 && selectedIdx>0) { selectedIdx--; if(selectedIdx<scroll) scroll--; return true; }
        return super.keyPressed(key, scan, mods);
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double hAmt, double vAmt) {
        if (vAmt<0 && scroll<results.size()-MAX_ROWS) scroll++;
        else if (vAmt>0 && scroll>0) scroll--;
        return true;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int btn) {
        int x=(width-W)/2, y=(height-H)/2;
        int listY=y+PAD+14+16, listX2=x+W/2-PAD;
        if (mx>=x+PAD && mx<=listX2 && my>=listY) {
            int row=(int)(my-listY)/ROW_H+scroll;
            if (row>=0 && row<results.size()) { selectedIdx=row; return true; }
        }
        return super.mouseClicked(mx, my, btn);
    }

    @Override
    public void render(GuiGraphics ctx, int mx, int my, float delta) {
        renderBackground(ctx, mx, my, delta);
        int x=(width-W)/2, y=(height-H)/2;
        ctx.fill(x,y,x+W,y+H,C_BG);
        ctx.fill(x,y,x+W,y+1,C_BORDER); ctx.fill(x,y+H-1,x+W,y+H,C_BORDER);
        ctx.fill(x,y,x+1,y+H,C_BORDER); ctx.fill(x+W-1,y,x+W,y+H,C_BORDER);
        String title="✦ Grimoire of Powers ✦";
        ctx.drawString(font, Component.literal(title), x+(W-font.width(title))/2, y+PAD, C_TITLE);
        super.render(ctx, mx, my, delta);
        int listY=y+PAD+14+16, listX2=x+W/2-PAD;
        ctx.drawString(font, Component.literal(results.size()+" powers"), x+PAD, listY-9, C_DIM);
        int visible=Math.min(MAX_ROWS, results.size()-scroll);
        for (int i=0; i<visible; i++) {
            int idx=i+scroll; PowerEntry e=results.get(idx); int ry=listY+i*ROW_H; boolean sel=idx==selectedIdx;
            if (sel) ctx.fill(x+PAD-1,ry-1,listX2+1,ry+ROW_H-2,C_SEL);
            int col=sel?0xFFFFFFFF:typeColor(e.type());
            ctx.drawString(font, Component.literal(icon(e.type())+e.name()), x+PAD, ry, col);
            if (!sel) { String cat=e.category(); ctx.drawString(font, Component.literal(cat), listX2-font.width(cat), ry, C_DIM); }
        }
        if (results.size()>MAX_ROWS) ctx.drawString(font, Component.literal("▲▼ scroll"), x+PAD, listY+MAX_ROWS*ROW_H+2, C_DIM);
        int divX=x+W/2; ctx.fill(divX,y+2,divX+1,y+H-2,0xFF1A2A55);
        int dX=divX+PAD, dY=y+PAD+14, dW=x+W-dX-PAD;
        if (!results.isEmpty() && selectedIdx<results.size()) {
            PowerEntry e=results.get(selectedIdx);
            ctx.drawString(font, Component.literal(e.name()), dX, dY, typeColor(e.type())); dY+=11;
            ctx.drawString(font, Component.literal(e.item()+"  ·  "+e.category()), dX, dY, 0xFF8899CC); dY+=10;
            ctx.drawString(font, Component.literal("["+e.type().toUpperCase()+"]"), dX, dY, typeColor(e.type())); dY+=12;
            ctx.fill(dX-1,dY-1,dX+dW+1,dY+12,0xFF0A1030);
            ctx.drawString(font, Component.literal("⌨ "+e.bind()), dX+2, dY+1, C_BIND); dY+=15;
            ctx.fill(dX,dY,dX+dW,dY+1,0xFF1A2A55); dY+=4;
            List<FormattedCharSequence> lines=font.split(Component.literal(e.description()).setStyle(Style.EMPTY.withColor(C_DESC)), dW);
            for (FormattedCharSequence line : lines) {
                if (dY+9>y+H-PAD) break;
                ctx.drawString(font, line, dX, dY, 0xFFFFFFFF); dY+=10;
            }
        } else {
            ctx.drawString(font, Component.literal("Geen resultaten.").withStyle(ChatFormatting.DARK_GRAY), dX, dY+30, C_DIM);
        }
    }

    private int typeColor(String t) { return switch(t.toLowerCase()){case"passive"->C_PASSIVE;case"active"->C_ACTIVE;case"ultimate"->C_ULTIMATE;default->0xFFFFFFFF;}; }
    private String icon(String t) { return switch(t.toLowerCase()){case"passive"->"◈ ";case"active"->"⚡ ";case"ultimate"->"★ ";default->"• ";}; }
    @Override public boolean isPauseScreen() { return false; }
}
