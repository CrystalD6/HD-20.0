package com.hardend.diamond.data;

import java.util.*;

public class PowerData {

    public record PowerEntry(String id, String name, String item, String category,
                              String type, String bind, String description) {}

    private static final List<PowerEntry> ALL = new ArrayList<>();
    private static final Map<String, PowerEntry> BY_ID = new LinkedHashMap<>();

    static {
        // SWORD
        reg("windstorm","Windstorm","Angel Sword","Sword","Active","Sprint + Jump","Springt omhoog en creëert een tornado met krachtige knockback rondom de speler.");
        reg("cloud_walking","Cloud Walking","Angel Sword","Sword","Active","Passief (in lucht)","Genereert tijdelijke luchtblokken onder de voeten met Feather Falling-effect.");
        reg("tractor_beam","Tractor Beam","Angel Sword","Sword","Active","RightClick (houd in)","Trekt vijanden naar de speler toe met een zichtbare lichtstraal.");
        reg("chaos_strike","Chaos Strike","Angel Sword","Sword","Active","LeftClick","Projectielen geven het doelwit 2 willekeurige debuffs.");
        reg("rain_effect","Rain Effect","Angel Sword","Sword","Active","LeftClick op jezelf","Geeft jezelf Slow Falling én Regeneration voor korte tijd.");
        reg("soul_slicer","Soul Slicer","Angel Sword","Sword","Passive","Passief (bij kill)","Elke kill healt de speler een klein beetje.");
        reg("aura_of_fear","Aura of Fear","Angel Sword","Sword","Passive","Passief (in radius)","Vijanden binnen de aura krijgen automatisch een willekeurige debuff.");
        reg("light_dash","Light Dash","Angel Sword","Sword","Active","Sprint + LeftClick","Teleporteert de speler snel voorwaarts in de kijkrichting.");
        reg("heavenly_slash","Heavenly Slash","Angel Sword","Sword","Active","RightClick","AoE schade met grote particle-slash in een boog om de speler.");
        reg("angel_blast","Ultimate Angel Blast","Angel Sword","Sword","Ultimate","Shift + LeftClick + RightClick","Gigantische lichtstraal met massive knockback en chaos op alle vijanden in de baan.");
        // PICKAXE
        reg("earthquake","Earthquake","Terra Breaker","Pickaxe","Active","RightClick (grond)","Breekt blokken in AoE rondom de speler én geeft knockback aan vijanden.");
        reg("vein_miner","Vein Miner","Terra Breaker","Pickaxe","Active","Shift + Abbouwen","Breekt een complete erts-vein in één keer af.");
        reg("magnetize","Magnetize","Terra Breaker","Pickaxe","Passive","Passief (altijd)","Drops worden automatisch naar de speler aangetrokken.");
        reg("stoneform","Stoneform","Terra Breaker","Pickaxe","Passive","Passief (op steen)","Extra armor-bonus als je op of nabij steen staat.");
        reg("seismic_slam","Seismic Slam","Terra Breaker","Pickaxe","Active","Jump + RightClick","Seismische AoE knockback-golf bij de landing.");
        reg("tunnel_vision","Tunnel Vision","Terra Breaker","Pickaxe","Active","Shift + RightClick","Graaft automatisch een tunnel recht vooruit.");
        reg("miners_luck","Miner's Luck","Terra Breaker","Pickaxe","Passive","Passief (bij drop)","Kleine kans op dubbele drops bij een gebroken blok.");
        reg("shockwave_break","Shockwave Break","Terra Breaker","Pickaxe","Active","RightClick","Breekt alle blokken in een 3×3 area rondom het aangeklikte blok.");
        // AXE
        reg("lightning_fury","Lightning Fury","Storm Cleaver","Axe","Active","LeftClick","Treft vijanden met bliksemschichten die ook debuffs geven.");
        reg("mini_tornado","Mini Tornado","Storm Cleaver","Axe","Passive","Passief (elke 3e hit)","Elke derde melee-hit spawnt een kleine tornado op de vijand.");
        reg("tree_crusher","Tree Crusher","Storm Cleaver","Axe","Passive","Passief (bij kappen)","Kapt bomen sneller en geeft knockback aan nabije vijanden.");
        reg("storm_armor","Storm Armor","Storm Cleaver","Axe","Passive","Passief (bij projectile)","Kans om inkomende projectielen te reflecteren.");
        reg("cyclone_slash","Cyclone Slash","Storm Cleaver","Axe","Active","Sprint + LeftClick","Spin-attack die alle vijanden rondom raakt.");
        reg("thunder_call","Thunder Call","Storm Cleaver","Axe","Active","Shift + RightClick","Roept blikseminslagen neer in grote radius rondom de speler.");
        reg("static_charge","Static Charge","Storm Cleaver","Axe","Passive","Passief (bij melee)","Kans op kleine elektrische AoE shock bij elke melee-treffer.");
        // SHOVEL
        reg("phantom_step","Phantom Step","Soul Digger","Shovel","Passive","Passief (op lava/water)","Loop over lava en water zonder schade of zinken.");
        reg("burrow","Burrow","Soul Digger","Shovel","Active","Shift + RightClick","Tunnelt snel onder de grond in de kijkrichting.");
        reg("sandstorm","Sandstorm","Soul Digger","Shovel","Active","Sprint + LeftClick","Zandstorm verblind vijanden in de buurt.");
        reg("treasure_magnet","Treasure Magnet","Soul Digger","Shovel","Passive","Passief (altijd)","Items worden aangetrokken vanuit grotere radius.");
        reg("shockwave_shovel","Shockwave","Soul Digger","Shovel","Active","Jump + RightClick","AoE knockback-golf bij landing.");
        reg("mudslide","Mudslide","Soul Digger","Shovel","Active","LeftClick (grond)","Modder vertraagt vijanden met particle-effect.");
        reg("excavator_blessing","Excavator's Blessing","Soul Digger","Shovel","Passive","Passief (bij graven)","Extra drops van aarde, zand en grind.");
        // HOE
        reg("blooming_aura","Blooming Aura","Nature's Call","Hoe","Active","RightClick (houd in)","Bufft bondgenoten en debufft vijanden in bloeiende aura.");
        reg("vine_grab","Vine Grab","Nature's Call","Hoe","Active","LeftClick (op vijand)","Ranke immobiliseert de vijand voor korte tijd.");
        reg("natures_gift","Nature's Gift","Nature's Call","Hoe","Passive","Passief (nabij natuur)","Regeneratie-buffs nabij bloemen of gras.");
        reg("spore_cloud","Spore Cloud","Nature's Call","Hoe","Active","RightClick","Giftige sporenwolk: AoE schade + Poison/Slowness.");
        reg("growth_burst","Growth Burst","Nature's Call","Hoe","Active","Shift + RightClick","Planten exploderen met knockback op nabije vijanden.");
        reg("root_snare","Root Snare","Nature's Call","Hoe","Passive","Passief (in radius)","Vijanden bewegen langzamer door wortels in de grond.");
        reg("fertilizer","Fertilizer","Nature's Call","Hoe","Passive","Passief (nabij gewassen)","Gewassen groeien sneller in de buurt van de speler.");
        // HELMET
        reg("eagle_eye","Eagle Eye","Celestial Visor","Helmet","Passive","Passief (altijd)","Markeert vijanden en geeft kritieke trefkans bonus.");
        reg("night_sight","Night Sight","Celestial Visor","Helmet","Passive","Passief (in donker)","Night Vision + verbeterd zicht in donkere omgevingen.");
        reg("mind_scan","Mind Scan","Celestial Visor","Helmet","Passive","Passief (in radius)","Health bars van vijanden zichtbaar in de buurt.");
        reg("starlight_beam","Starlight Beam","Celestial Visor","Helmet","Active","LeftClick (richten)","Lichtstraal op vijand: schade + blindheid.");
        reg("astral_shield","Astral Shield","Celestial Visor","Helmet","Active","Shift + RightClick","Reflecteert de volgende aanval volledig terug.");
        reg("celestial_guidance","Celestial Guidance","Celestial Visor","Helmet","Passive","Passief (altijd)","Verhoogt kans dat projectielen het doel raken.");
        reg("meteor_warning","Meteor Warning","Celestial Visor","Helmet","Passive","Passief (detectie)","Waarschuwt als er een projectiel aankomt.");
        // CHESTPLATE
        reg("reflective_shield","Reflective Shield","Guardian Aegis","Chestplate","Passive","Passief (bij melee)","Kans om melee-projectielen terug te kaatsen.");
        reg("shockwave_defense","Shockwave Defense","Guardian Aegis","Chestplate","Active","Passief (bij schade)","AoE knockback burst bij het ontvangen van een treffer.");
        reg("blessed_aura","Blessed Aura","Guardian Aegis","Chestplate","Passive","Passief (in radius)","Bondgenoten in buurt krijgen klein regeneratie-effect.");
        reg("fire_ward","Fire Ward","Guardian Aegis","Chestplate","Passive","Passief (bij vuur)","Kans om vuur-aanvallen te reflecteren.");
        reg("divine_retribution","Divine Retribution","Guardian Aegis","Chestplate","Active","Shift + LeftClick","AoE knockback + schade burst rondom de speler.");
        reg("fortress_stance","Fortress Stance","Guardian Aegis","Chestplate","Passive","Passief (altijd)","Significant minder knockback van vijanden.");
        reg("holy_barrier","Holy Barrier","Guardian Aegis","Chestplate","Passive","Passief (altijd)","Kleine kans dat negatieve effecten genegeerd worden.");
        // LEGGINGS
        reg("dash_step","Dash Step","Windrunner Greaves","Leggings","Active","Sprint + Jump","AoE Slowness rondom bij een sprint-sprong.");
        reg("leap_strike","Leap Strike","Windrunner Greaves","Leggings","Active","Jump + LeftClick","Sprong met impact: schade + knockback bij landing.");
        reg("speed_aura","Speed Aura","Windrunner Greaves","Leggings","Passive","Passief (in radius)","Bondgenoten in buurt krijgen Speed boost.");
        reg("wind_barrier","Wind Barrier","Windrunner Greaves","Leggings","Passive","Passief (bij projectile)","Kans om projectielen af te buigen.");
        reg("sky_piercer","Sky Piercer","Windrunner Greaves","Leggings","Active","Shift + RightClick","Lanceer jezelf snel vooruit door de lucht.");
        reg("cyclone_legs","Cyclone Legs","Windrunner Greaves","Leggings","Active","Sprint + LeftClick","Draaiende AoE knockback bij rennen.");
        reg("air_glide","Air Glide","Windrunner Greaves","Leggings","Passive","Passief (in lucht)","Langzaam vallen als je in de lucht bent.");
        // BOOTS
        reg("meteor_landing","Meteor Landing","Comet Striders","Boots","Active","Passief (bij val)","Knockback burst rondom bij landen na een val.");
        reg("feather_fall","Feather Fall","Comet Striders","Boots","Passive","Passief (altijd)","Geen val-schade: je landt altijd veilig.");
        reg("trail_fire_ice","Trail of Fire/Ice","Comet Striders","Boots","Passive","Passief (bij sprint)","Sprint laat tijdelijk vuur of ijs achter.");
        reg("double_jump","Double Jump","Comet Striders","Boots","Active","Jump (in lucht)","Extra sprong midden in de lucht.");
        reg("gravity_slam","Gravity Slam","Comet Striders","Boots","Active","Shift + Jump","Massieve AoE impact bij landing.");
        reg("comet_dash","Comet Dash","Comet Striders","Boots","Active","Sprint + RightClick","Snelle dash met knockback in de kijkrichting.");
        reg("star_step","Star Step","Comet Striders","Boots","Passive","Passief (bij landing)","Kleine kans om vijanden te stunnen bij landing.");
        // SET COMBO
        reg("celestial_wrath","Celestial Wrath","Full Set","Set Combo","Ultimate","Shift + LeftClick + RightClick (volledig set)","Gigantische lichtstraal. Vijanden: knockback + debuffs. Bondgenoten: Speed, Jump Boost, Regeneration, Damage Boost. Multi-layer particles. Cooldown: 3 min.");
    }

    private static void reg(String id, String name, String item, String cat, String type, String bind, String desc) {
        PowerEntry e = new PowerEntry(id, name, item, cat, type, bind, desc);
        ALL.add(e);
        BY_ID.put(id, e);
    }

    public static List<PowerEntry> getAll() { return Collections.unmodifiableList(ALL); }

    public static List<PowerEntry> search(String query) {
        if (query == null || query.isBlank()) return getAll();
        String q = query.toLowerCase(java.util.Locale.ROOT);
        return ALL.stream().filter(e ->
            e.name().toLowerCase().contains(q) ||
            e.item().toLowerCase().contains(q) ||
            e.category().toLowerCase().contains(q) ||
            e.type().toLowerCase().contains(q) ||
            e.description().toLowerCase().contains(q) ||
            e.bind().toLowerCase().contains(q)
        ).toList();
    }
}
