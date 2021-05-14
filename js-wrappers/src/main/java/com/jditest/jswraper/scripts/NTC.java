package com.jditest.jswraper.scripts;

public class NTC {
    public static final String script =
        "window.jdi = {}\n" +
        "jdi.ntc={\n" +
        "  init: function() {\n" +
        "    var color, rgb, hsl;\n" +
        "    for(var i = 0; i < jdi.ntc.names.length; i++)\n" +
        "    {\n" +
        "      color = \"#\" + jdi.ntc.names[i][0];\n" +
        "      rgb = jdi.ntc.rgb(color);\n" +
        "      hsl = jdi.ntc.hsl(color);\n" +
        "      jdi.ntc.names[i].push(rgb[0], rgb[1], rgb[2], hsl[0], hsl[1], hsl[2]);\n" +
        "    }\n" +
        "  },\n" +
        "  name: function(color) {\n" +
        "    color = color.toUpperCase();\n" +
        "    if (color.startsWith('RGB')) {\n" +
        "      color = '#' + color.substr(4, color.indexOf(')') - 4).split(',').map((cl) => parseInt(cl).toString(16)).join('');\n" +
        "    }\n" +
        "    if(color.length < 3 || color.length > 7)\n" +
        "      return [\"#000000\", \"Invalid Color: \" + color, false];\n" +
        "    if(color.length % 3 == 0)\n" +
        "      color = \"#\" + color;\n" +
        "    if(color.length == 4)\n" +
        "      color = \"#\" + color.substr(1, 1) + color.substr(1, 1) + color.substr(2, 1) + color.substr(2, 1) + color.substr(3, 1) + color.substr(3, 1);\n" +
        "    var rgb = jdi.ntc.rgb(color);\n" +
        "    var r = rgb[0], g = rgb[1], b = rgb[2];\n" +
        "    var hsl = jdi.ntc.hsl(color);\n" +
        "    var h = hsl[0], s = hsl[1], l = hsl[2];\n" +
        "    var ndf1 = 0; ndf2 = 0; ndf = 0;\n" +
        "    var cl = -1, df = -1;\n" +
        "    for(var i = 0; i < jdi.ntc.names.length; i++)\n" +
        "    {\n" +
        "      if(color == \"#\" + jdi.ntc.names[i][0])\n" +
        "        return [\"#\" + jdi.ntc.names[i][0], jdi.ntc.names[i][1], true];\n" +
        "      ndf1 = Math.pow(r - jdi.ntc.names[i][2], 2) + Math.pow(g - jdi.ntc.names[i][3], 2) + Math.pow(b - jdi.ntc.names[i][4], 2);\n" +
        "      ndf2 = Math.pow(h - jdi.ntc.names[i][5], 2) + Math.pow(s - jdi.ntc.names[i][6], 2) + Math.pow(l - jdi.ntc.names[i][7], 2);\n" +
        "      ndf = ndf1 + ndf2 * 2;\n" +
        "      if(df < 0 || df > ndf)\n" +
        "      {\n" +
        "        df = ndf;\n" +
        "        cl = i;\n" +
        "      }\n" +
        "    }\n" +
        "\n" +
        "    return (cl < 0 ? [\"#000000\", \"Invalid Color: \" + color, false] : [\"#\" + jdi.ntc.names[cl][0], jdi.ntc.names[cl][1], false]);\n" +
        "  },\n" +
        "  hsl: function (color) {\n" +
        "    var rgb = [parseInt('0x' + color.substring(1, 3)) / 255, parseInt('0x' + color.substring(3, 5)) / 255, parseInt('0x' + color.substring(5, 7)) / 255];\n" +
        "    var min, max, delta, h, s, l;\n" +
        "    var r = rgb[0], g = rgb[1], b = rgb[2];\n" +
        "    min = Math.min(r, Math.min(g, b));\n" +
        "    max = Math.max(r, Math.max(g, b));\n" +
        "    delta = max - min;\n" +
        "    l = (min + max) / 2;\n" +
        "    s = 0;\n" +
        "    if(l > 0 && l < 1)\n" +
        "      s = delta / (l < 0.5 ? (2 * l) : (2 - 2 * l));\n" +
        "    h = 0;\n" +
        "    if(delta > 0)\n" +
        "    {\n" +
        "      if (max == r && max != g) h += (g - b) / delta;\n" +
        "      if (max == g && max != b) h += (2 + (b - r) / delta);\n" +
        "      if (max == b && max != r) h += (4 + (r - g) / delta);\n" +
        "      h /= 6;\n" +
        "    }\n" +
        "    return [parseInt(h * 255), parseInt(s * 255), parseInt(l * 255)];\n" +
        "  },\n" +
        "  // adopted from: Farbtastic 1.2\n" +
        "  // http://acko.net/dev/farbtastic\n" +
        "  rgb: function(color) {\n" +
        "    return [parseInt('0x' + color.substring(1, 3)), parseInt('0x' + color.substring(3, 5)),  parseInt('0x' + color.substring(5, 7))];\n" +
        "  },\n" +
        "  names: [\n" +
        "[\"000000\", \"Black\"],\n" +
        "[\"000080\", \"Navy Blue\"],\n" +
        "[\"0000C8\", \"Dark Blue\"],\n" +
        "[\"0000FF\", \"Blue\"],\n" +
        "[\"000741\", \"Stratos\"],\n" +
        "[\"001B1C\", \"Swamp\"],\n" +
        "[\"002387\", \"Resolution Blue\"],\n" +
        "[\"002900\", \"Deep Fir\"],\n" +
        "[\"002E20\", \"Burnham\"],\n" +
        "[\"002FA7\", \"International Klein Blue\"],\n" +
        "[\"003153\", \"Prussian Blue\"],\n" +
        "[\"003366\", \"Midnight Blue\"],\n" +
        "[\"003399\", \"Smalt\"],\n" +
        "[\"003532\", \"Deep Teal\"],\n" +
        "[\"003E40\", \"Cyprus\"],\n" +
        "[\"004620\", \"Kaitoke Green\"],\n" +
        "[\"0047AB\", \"Cobalt\"],\n" +
        "[\"004816\", \"Crusoe\"],\n" +
        "[\"004950\", \"Sherpa Blue\"],\n" +
        "[\"0056A7\", \"Endeavour\"],\n" +
        "[\"00581A\", \"Camarone\"],\n" +
        "[\"0066CC\", \"Science Blue\"],\n" +
        "[\"0066FF\", \"Blue Ribbon\"],\n" +
        "[\"00755E\", \"Tropical Rain Forest\"],\n" +
        "[\"0076A3\", \"Allports\"],\n" +
        "[\"007BA7\", \"Deep Cerulean\"],\n" +
        "[\"007EC7\", \"Lochmara\"],\n" +
        "[\"007FFF\", \"Azure Radiance\"],\n" +
        "[\"008080\", \"Teal\"],\n" +
        "[\"0095B6\", \"Bondi Blue\"],\n" +
        "[\"009DC4\", \"Pacific Blue\"],\n" +
        "[\"00A693\", \"Persian Green\"],\n" +
        "[\"00A86B\", \"Jade\"],\n" +
        "[\"00CC99\", \"Caribbean Green\"],\n" +
        "[\"00CCCC\", \"Robin's Egg Blue\"],\n" +
        "[\"00FF00\", \"Green\"],\n" +
        "[\"00FF7F\", \"Spring Green\"],\n" +
        "[\"00FFFF\", \"Cyan / Aqua\"],\n" +
        "[\"010D1A\", \"Blue Charcoal\"],\n" +
        "[\"011635\", \"Midnight\"],\n" +
        "[\"011D13\", \"Holly\"],\n" +
        "[\"012731\", \"Daintree\"],\n" +
        "[\"01361C\", \"Cardin Green\"],\n" +
        "[\"01371A\", \"County Green\"],\n" +
        "[\"013E62\", \"Astronaut Blue\"],\n" +
        "[\"013F6A\", \"Regal Blue\"],\n" +
        "[\"014B43\", \"Aqua Deep\"],\n" +
        "[\"015E85\", \"Orient\"],\n" +
        "[\"016162\", \"Blue Stone\"],\n" +
        "[\"016D39\", \"Fun Green\"],\n" +
        "[\"01796F\", \"Pine Green\"],\n" +
        "[\"017987\", \"Blue Lagoon\"],\n" +
        "[\"01826B\", \"Deep Sea\"],\n" +
        "[\"01A368\", \"Green Haze\"],\n" +
        "[\"022D15\", \"English Holly\"],\n" +
        "[\"02402C\", \"Sherwood Green\"],\n" +
        "[\"02478E\", \"Congress Blue\"],\n" +
        "[\"024E46\", \"Evening Sea\"],\n" +
        "[\"026395\", \"Bahama Blue\"],\n" +
        "[\"02866F\", \"Observatory\"],\n" +
        "[\"02A4D3\", \"Cerulean\"],\n" +
        "[\"03163C\", \"Tangaroa\"],\n" +
        "[\"032B52\", \"Green Vogue\"],\n" +
        "[\"036A6E\", \"Mosque\"],\n" +
        "[\"041004\", \"Midnight Moss\"],\n" +
        "[\"041322\", \"Black Pearl\"],\n" +
        "[\"042E4C\", \"Blue Whale\"],\n" +
        "[\"044022\", \"Zuccini\"],\n" +
        "[\"044259\", \"Teal Blue\"],\n" +
        "[\"051040\", \"Deep Cove\"],\n" +
        "[\"051657\", \"Gulf Blue\"],\n" +
        "[\"055989\", \"Venice Blue\"],\n" +
        "[\"056F57\", \"Watercourse\"],\n" +
        "[\"062A78\", \"Catalina Blue\"],\n" +
        "[\"063537\", \"Tiber\"],\n" +
        "[\"069B81\", \"Gossamer\"],\n" +
        "[\"06A189\", \"Niagara\"],\n" +
        "[\"073A50\", \"Tarawera\"],\n" +
        "[\"080110\", \"Jaguar\"],\n" +
        "[\"081910\", \"Black Bean\"],\n" +
        "[\"082567\", \"Deep Sapphire\"],\n" +
        "[\"088370\", \"Elf Green\"],\n" +
        "[\"08E8DE\", \"Bright Turquoise\"],\n" +
        "[\"092256\", \"Downriver\"],\n" +
        "[\"09230F\", \"Palm Green\"],\n" +
        "[\"09255D\", \"Madison\"],\n" +
        "[\"093624\", \"Bottle Green\"],\n" +
        "[\"095859\", \"Deep Sea Green\"],\n" +
        "[\"097F4B\", \"Salem\"],\n" +
        "[\"0A001C\", \"Black Russian\"],\n" +
        "[\"0A480D\", \"Dark Fern\"],\n" +
        "[\"0A6906\", \"Japanese Laurel\"],\n" +
        "[\"0A6F75\", \"Atoll\"],\n" +
        "[\"0B0B0B\", \"Cod Gray\"],\n" +
        "[\"0B0F08\", \"Marshland\"],\n" +
        "[\"0B1107\", \"Gordons Green\"],\n" +
        "[\"0B1304\", \"Black Forest\"],\n" +
        "[\"0B6207\", \"San Felix\"],\n" +
        "[\"0BDA51\", \"Malachite\"],\n" +
        "[\"0C0B1D\", \"Ebony\"],\n" +
        "[\"0C0D0F\", \"Woodsmoke\"],\n" +
        "[\"0C1911\", \"Racing Green\"],\n" +
        "[\"0C7A79\", \"Surfie Green\"],\n" +
        "[\"0C8990\", \"Blue Chill\"],\n" +
        "[\"0D0332\", \"Black Rock\"],\n" +
        "[\"0D1117\", \"Bunker\"],\n" +
        "[\"0D1C19\", \"Aztec\"],\n" +
        "[\"0D2E1C\", \"Bush\"],\n" +
        "[\"0E0E18\", \"Cinder\"],\n" +
        "[\"0E2A30\", \"Firefly\"],\n" +
        "[\"0F2D9E\", \"Torea Bay\"],\n" +
        "[\"10121D\", \"Vulcan\"],\n" +
        "[\"101405\", \"Green Waterloo\"],\n" +
        "[\"105852\", \"Eden\"],\n" +
        "[\"110C6C\", \"Arapawa\"],\n" +
        "[\"120A8F\", \"Ultramarine\"],\n" +
        "[\"123447\", \"Elephant\"],\n" +
        "[\"126B40\", \"Jewel\"],\n" +
        "[\"130000\", \"Diesel\"],\n" +
        "[\"130A06\", \"Asphalt\"],\n" +
        "[\"13264D\", \"Blue Zodiac\"],\n" +
        "[\"134F19\", \"Parsley\"],\n" +
        "[\"140600\", \"Nero\"],\n" +
        "[\"1450AA\", \"Tory Blue\"],\n" +
        "[\"151F4C\", \"Bunting\"],\n" +
        "[\"1560BD\", \"Denim\"],\n" +
        "[\"15736B\", \"Genoa\"],\n" +
        "[\"161928\", \"Mirage\"],\n" +
        "[\"161D10\", \"Hunter Green\"],\n" +
        "[\"162A40\", \"Big Stone\"],\n" +
        "[\"163222\", \"Celtic\"],\n" +
        "[\"16322C\", \"Timber Green\"],\n" +
        "[\"163531\", \"Gable Green\"],\n" +
        "[\"171F04\", \"Pine Tree\"],\n" +
        "[\"175579\", \"Chathams Blue\"],\n" +
        "[\"182D09\", \"Deep Forest Green\"],\n" +
        "[\"18587A\", \"Blumine\"],\n" +
        "[\"19330E\", \"Palm Leaf\"],\n" +
        "[\"193751\", \"Nile Blue\"],\n" +
        "[\"1959A8\", \"Fun Blue\"],\n" +
        "[\"1A1A68\", \"Lucky Point\"],\n" +
        "[\"1AB385\", \"Mountain Meadow\"],\n" +
        "[\"1B0245\", \"Tolopea\"],\n" +
        "[\"1B1035\", \"Haiti\"],\n" +
        "[\"1B127B\", \"Deep Koamaru\"],\n" +
        "[\"1B1404\", \"Acadia\"],\n" +
        "[\"1B2F11\", \"Seaweed\"],\n" +
        "[\"1B3162\", \"Biscay\"],\n" +
        "[\"1B659D\", \"Matisse\"],\n" +
        "[\"1C1208\", \"Crowshead\"],\n" +
        "[\"1C1E13\", \"Rangoon Green\"],\n" +
        "[\"1C39BB\", \"Persian Blue\"],\n" +
        "[\"1C402E\", \"Everglade\"],\n" +
        "[\"1C7C7D\", \"Elm\"],\n" +
        "[\"1D6142\", \"Green Pea\"],\n" +
        "[\"1E0F04\", \"Creole\"],\n" +
        "[\"1E1609\", \"Karaka\"],\n" +
        "[\"1E1708\", \"El Paso\"],\n" +
        "[\"1E385B\", \"Cello\"],\n" +
        "[\"1E433C\", \"Te Papa Green\"],\n" +
        "[\"1E90FF\", \"Dodger Blue\"],\n" +
        "[\"1E9AB0\", \"Eastern Blue\"],\n" +
        "[\"1F120F\", \"Night Rider\"],\n" +
        "[\"1FC2C2\", \"Java\"],\n" +
        "[\"20208D\", \"Jacksons Purple\"],\n" +
        "[\"202E54\", \"Cloud Burst\"],\n" +
        "[\"204852\", \"Blue Dianne\"],\n" +
        "[\"211A0E\", \"Eternity\"],\n" +
        "[\"220878\", \"Deep Blue\"],\n" +
        "[\"228B22\", \"Forest Green\"],\n" +
        "[\"233418\", \"Mallard\"],\n" +
        "[\"240A40\", \"Violet\"],\n" +
        "[\"240C02\", \"Kilamanjaro\"],\n" +
        "[\"242A1D\", \"Log Cabin\"],\n" +
        "[\"242E16\", \"Black Olive\"],\n" +
        "[\"24500F\", \"Green House\"],\n" +
        "[\"251607\", \"Graphite\"],\n" +
        "[\"251706\", \"Cannon Black\"],\n" +
        "[\"251F4F\", \"Port Gore\"],\n" +
        "[\"25272C\", \"Shark\"],\n" +
        "[\"25311C\", \"Green Kelp\"],\n" +
        "[\"2596D1\", \"Curious Blue\"],\n" +
        "[\"260368\", \"Paua\"],\n" +
        "[\"26056A\", \"Paris M\"],\n" +
        "[\"261105\", \"Wood Bark\"],\n" +
        "[\"261414\", \"Gondola\"],\n" +
        "[\"262335\", \"Steel Gray\"],\n" +
        "[\"26283B\", \"Ebony Clay\"],\n" +
        "[\"273A81\", \"Bay of Many\"],\n" +
        "[\"27504B\", \"Plantation\"],\n" +
        "[\"278A5B\", \"Eucalyptus\"],\n" +
        "[\"281E15\", \"Oil\"],\n" +
        "[\"283A77\", \"Astronaut\"],\n" +
        "[\"286ACD\", \"Mariner\"],\n" +
        "[\"290C5E\", \"Violent Violet\"],\n" +
        "[\"292130\", \"Bastille\"],\n" +
        "[\"292319\", \"Zeus\"],\n" +
        "[\"292937\", \"Charade\"],\n" +
        "[\"297B9A\", \"Jelly Bean\"],\n" +
        "[\"29AB87\", \"Jungle Green\"],\n" +
        "[\"2A0359\", \"Cherry Pie\"],\n" +
        "[\"2A140E\", \"Coffee Bean\"],\n" +
        "[\"2A2630\", \"Baltic Sea\"],\n" +
        "[\"2A380B\", \"Turtle Green\"],\n" +
        "[\"2A52BE\", \"Cerulean Blue\"],\n" +
        "[\"2B0202\", \"Sepia Black\"],\n" +
        "[\"2B194F\", \"Valhalla\"],\n" +
        "[\"2B3228\", \"Heavy Metal\"],\n" +
        "[\"2C0E8C\", \"Blue Gem\"],\n" +
        "[\"2C1632\", \"Revolver\"],\n" +
        "[\"2C2133\", \"Bleached Cedar\"],\n" +
        "[\"2C8C84\", \"Lochinvar\"],\n" +
        "[\"2D2510\", \"Mikado\"],\n" +
        "[\"2D383A\", \"Outer Space\"],\n" +
        "[\"2D569B\", \"St Tropaz\"],\n" +
        "[\"2E0329\", \"Jacaranda\"],\n" +
        "[\"2E1905\", \"Jacko Bean\"],\n" +
        "[\"2E3222\", \"Rangitoto\"],\n" +
        "[\"2E3F62\", \"Rhino\"],\n" +
        "[\"2E8B57\", \"Sea Green\"],\n" +
        "[\"2EBFD4\", \"Scooter\"],\n" +
        "[\"2F270E\", \"Onion\"],\n" +
        "[\"2F3CB3\", \"Governor Bay\"],\n" +
        "[\"2F519E\", \"Sapphire\"],\n" +
        "[\"2F5A57\", \"Spectra\"],\n" +
        "[\"2F6168\", \"Casal\"],\n" +
        "[\"300529\", \"Melanzane\"],\n" +
        "[\"301F1E\", \"Cocoa Brown\"],\n" +
        "[\"302A0F\", \"Woodrush\"],\n" +
        "[\"304B6A\", \"San Juan\"],\n" +
        "[\"30D5C8\", \"Turquoise\"],\n" +
        "[\"311C17\", \"Eclipse\"],\n" +
        "[\"314459\", \"Pickled Bluewood\"],\n" +
        "[\"315BA1\", \"Azure\"],\n" +
        "[\"31728D\", \"Calypso\"],\n" +
        "[\"317D82\", \"Paradiso\"],\n" +
        "[\"32127A\", \"Persian Indigo\"],\n" +
        "[\"32293A\", \"Blackcurrant\"],\n" +
        "[\"323232\", \"Mine Shaft\"],\n" +
        "[\"325D52\", \"Stromboli\"],\n" +
        "[\"327C14\", \"Bilbao\"],\n" +
        "[\"327DA0\", \"Astral\"],\n" +
        "[\"33036B\", \"Christalle\"],\n" +
        "[\"33292F\", \"Thunder\"],\n" +
        "[\"33CC99\", \"Shamrock\"],\n" +
        "[\"341515\", \"Tamarind\"],\n" +
        "[\"350036\", \"Mardi Gras\"],\n" +
        "[\"350E42\", \"Valentino\"],\n" +
        "[\"350E57\", \"Jagger\"],\n" +
        "[\"353542\", \"Tuna\"],\n" +
        "[\"354E8C\", \"Chambray\"],\n" +
        "[\"363050\", \"Martinique\"],\n" +
        "[\"363534\", \"Tuatara\"],\n" +
        "[\"363C0D\", \"Waiouru\"],\n" +
        "[\"36747D\", \"Ming\"],\n" +
        "[\"368716\", \"La Palma\"],\n" +
        "[\"370202\", \"Chocolate\"],\n" +
        "[\"371D09\", \"Clinker\"],\n" +
        "[\"37290E\", \"Brown Tumbleweed\"],\n" +
        "[\"373021\", \"Birch\"],\n" +
        "[\"377475\", \"Oracle\"],\n" +
        "[\"380474\", \"Blue Diamond\"],\n" +
        "[\"381A51\", \"Grape\"],\n" +
        "[\"383533\", \"Dune\"],\n" +
        "[\"384555\", \"Oxford Blue\"],\n" +
        "[\"384910\", \"Clover\"],\n" +
        "[\"394851\", \"Limed Spruce\"],\n" +
        "[\"396413\", \"Dell\"],\n" +
        "[\"3A0020\", \"Toledo\"],\n" +
        "[\"3A2010\", \"Sambuca\"],\n" +
        "[\"3A2A6A\", \"Jacarta\"],\n" +
        "[\"3A686C\", \"William\"],\n" +
        "[\"3A6A47\", \"Killarney\"],\n" +
        "[\"3AB09E\", \"Keppel\"],\n" +
        "[\"3B000B\", \"Temptress\"],\n" +
        "[\"3B0910\", \"Aubergine\"],\n" +
        "[\"3B1F1F\", \"Jon\"],\n" +
        "[\"3B2820\", \"Treehouse\"],\n" +
        "[\"3B7A57\", \"Amazon\"],\n" +
        "[\"3B91B4\", \"Boston Blue\"],\n" +
        "[\"3C0878\", \"Windsor\"],\n" +
        "[\"3C1206\", \"Rebel\"],\n" +
        "[\"3C1F76\", \"Meteorite\"],\n" +
        "[\"3C2005\", \"Dark Ebony\"],\n" +
        "[\"3C3910\", \"Camouflage\"],\n" +
        "[\"3C4151\", \"Bright Gray\"],\n" +
        "[\"3C4443\", \"Cape Cod\"],\n" +
        "[\"3C493A\", \"Lunar Green\"],\n" +
        "[\"3D0C02\", \"Bean  \"],\n" +
        "[\"3D2B1F\", \"Bistre\"],\n" +
        "[\"3D7D52\", \"Goblin\"],\n" +
        "[\"3E0480\", \"Kingfisher Daisy\"],\n" +
        "[\"3E1C14\", \"Cedar\"],\n" +
        "[\"3E2B23\", \"English Walnut\"],\n" +
        "[\"3E2C1C\", \"Black Marlin\"],\n" +
        "[\"3E3A44\", \"Ship Gray\"],\n" +
        "[\"3EABBF\", \"Pelorous\"],\n" +
        "[\"3F2109\", \"Bronze\"],\n" +
        "[\"3F2500\", \"Cola\"],\n" +
        "[\"3F3002\", \"Madras\"],\n" +
        "[\"3F307F\", \"Minsk\"],\n" +
        "[\"3F4C3A\", \"Cabbage Pont\"],\n" +
        "[\"3F583B\", \"Tom Thumb\"],\n" +
        "[\"3F5D53\", \"Mineral Green\"],\n" +
        "[\"3FC1AA\", \"Puerto Rico\"],\n" +
        "[\"3FFF00\", \"Harlequin\"],\n" +
        "[\"401801\", \"Brown Pod\"],\n" +
        "[\"40291D\", \"Cork\"],\n" +
        "[\"403B38\", \"Masala\"],\n" +
        "[\"403D19\", \"Thatch Green\"],\n" +
        "[\"405169\", \"Fiord\"],\n" +
        "[\"40826D\", \"Viridian\"],\n" +
        "[\"40A860\", \"Chateau Green\"],\n" +
        "[\"410056\", \"Ripe Plum\"],\n" +
        "[\"411F10\", \"Paco\"],\n" +
        "[\"412010\", \"Deep Oak\"],\n" +
        "[\"413C37\", \"Merlin\"],\n" +
        "[\"414257\", \"Gun Powder\"],\n" +
        "[\"414C7D\", \"East Bay\"],\n" +
        "[\"4169E1\", \"Royal Blue\"],\n" +
        "[\"41AA78\", \"Ocean Green\"],\n" +
        "[\"420303\", \"Burnt Maroon\"],\n" +
        "[\"423921\", \"Lisbon Brown\"],\n" +
        "[\"427977\", \"Faded Jade\"],\n" +
        "[\"431560\", \"Scarlet Gum\"],\n" +
        "[\"433120\", \"Iroko\"],\n" +
        "[\"433E37\", \"Armadillo\"],\n" +
        "[\"434C59\", \"River Bed\"],\n" +
        "[\"436A0D\", \"Green Leaf\"],\n" +
        "[\"44012D\", \"Barossa\"],\n" +
        "[\"441D00\", \"Morocco Brown\"],\n" +
        "[\"444954\", \"Mako\"],\n" +
        "[\"454936\", \"Kelp\"],\n" +
        "[\"456CAC\", \"San Marino\"],\n" +
        "[\"45B1E8\", \"Picton Blue\"],\n" +
        "[\"460B41\", \"Loulou\"],\n" +
        "[\"462425\", \"Crater Brown\"],\n" +
        "[\"465945\", \"Gray Asparagus\"],\n" +
        "[\"4682B4\", \"Steel Blue\"],\n" +
        "[\"480404\", \"Rustic Red\"],\n" +
        "[\"480607\", \"Bulgarian Rose\"],\n" +
        "[\"480656\", \"Clairvoyant\"],\n" +
        "[\"481C1C\", \"Cocoa Bean\"],\n" +
        "[\"483131\", \"Woody Brown\"],\n" +
        "[\"483C32\", \"Taupe\"],\n" +
        "[\"49170C\", \"Van Cleef\"],\n" +
        "[\"492615\", \"Brown Derby\"],\n" +
        "[\"49371B\", \"Metallic Bronze\"],\n" +
        "[\"495400\", \"Verdun Green\"],\n" +
        "[\"496679\", \"Blue Bayoux\"],\n" +
        "[\"497183\", \"Bismark\"],\n" +
        "[\"4A2A04\", \"Bracken\"],\n" +
        "[\"4A3004\", \"Deep Bronze\"],\n" +
        "[\"4A3C30\", \"Mondo\"],\n" +
        "[\"4A4244\", \"Tundora\"],\n" +
        "[\"4A444B\", \"Gravel\"],\n" +
        "[\"4A4E5A\", \"Trout\"],\n" +
        "[\"4B0082\", \"Pigment Indigo\"],\n" +
        "[\"4B5D52\", \"Nandor\"],\n" +
        "[\"4C3024\", \"Saddle\"],\n" +
        "[\"4C4F56\", \"Abbey\"],\n" +
        "[\"4D0135\", \"Blackberry\"],\n" +
        "[\"4D0A18\", \"Cab Sav\"],\n" +
        "[\"4D1E01\", \"Indian Tan\"],\n" +
        "[\"4D282D\", \"Cowboy\"],\n" +
        "[\"4D282E\", \"Livid Brown\"],\n" +
        "[\"4D3833\", \"Rock\"],\n" +
        "[\"4D3D14\", \"Punga\"],\n" +
        "[\"4D400F\", \"Bronzetone\"],\n" +
        "[\"4D5328\", \"Woodland\"],\n" +
        "[\"4E0606\", \"Mahogany\"],\n" +
        "[\"4E2A5A\", \"Bossanova\"],\n" +
        "[\"4E3B41\", \"Matterhorn\"],\n" +
        "[\"4E420C\", \"Bronze Olive\"],\n" +
        "[\"4E4562\", \"Mulled Wine\"],\n" +
        "[\"4E6649\", \"Axolotl\"],\n" +
        "[\"4E7F9E\", \"Wedgewood\"],\n" +
        "[\"4EABD1\", \"Shakespeare\"],\n" +
        "[\"4F1C70\", \"Honey Flower\"],\n" +
        "[\"4F2398\", \"Daisy Bush\"],\n" +
        "[\"4F69C6\", \"Indigo\"],\n" +
        "[\"4F7942\", \"Fern Green\"],\n" +
        "[\"4F9D5D\", \"Fruit Salad\"],\n" +
        "[\"4FA83D\", \"Apple\"],\n" +
        "[\"504351\", \"Mortar\"],\n" +
        "[\"507096\", \"Kashmir Blue\"],\n" +
        "[\"507672\", \"Cutty Sark\"],\n" +
        "[\"50C878\", \"Emerald\"],\n" +
        "[\"514649\", \"Emperor\"],\n" +
        "[\"516E3D\", \"Chalet Green\"],\n" +
        "[\"517C66\", \"Como\"],\n" +
        "[\"51808F\", \"Smalt Blue\"],\n" +
        "[\"52001F\", \"Castro\"],\n" +
        "[\"520C17\", \"Maroon Oak\"],\n" +
        "[\"523C94\", \"Gigas\"],\n" +
        "[\"533455\", \"Voodoo\"],\n" +
        "[\"534491\", \"Victoria\"],\n" +
        "[\"53824B\", \"Hippie Green\"],\n" +
        "[\"541012\", \"Heath\"],\n" +
        "[\"544333\", \"Judge Gray\"],\n" +
        "[\"54534D\", \"Fuscous Gray\"],\n" +
        "[\"549019\", \"Vida Loca\"],\n" +
        "[\"55280C\", \"Cioccolato\"],\n" +
        "[\"555B10\", \"Saratoga\"],\n" +
        "[\"556D56\", \"Finlandia\"],\n" +
        "[\"5590D9\", \"Havelock Blue\"],\n" +
        "[\"56B4BE\", \"Fountain Blue\"],\n" +
        "[\"578363\", \"Spring Leaves\"],\n" +
        "[\"583401\", \"Saddle Brown\"],\n" +
        "[\"585562\", \"Scarpa Flow\"],\n" +
        "[\"587156\", \"Cactus\"],\n" +
        "[\"589AAF\", \"Hippie Blue\"],\n" +
        "[\"591D35\", \"Wine Berry\"],\n" +
        "[\"592804\", \"Brown Bramble\"],\n" +
        "[\"593737\", \"Congo Brown\"],\n" +
        "[\"594433\", \"Millbrook\"],\n" +
        "[\"5A6E9C\", \"Waikawa Gray\"],\n" +
        "[\"5A87A0\", \"Horizon\"],\n" +
        "[\"5B3013\", \"Jambalaya\"],\n" +
        "[\"5C0120\", \"Bordeaux\"],\n" +
        "[\"5C0536\", \"Mulberry Wood\"],\n" +
        "[\"5C2E01\", \"Carnaby Tan\"],\n" +
        "[\"5C5D75\", \"Comet\"],\n" +
        "[\"5D1E0F\", \"Redwood\"],\n" +
        "[\"5D4C51\", \"Don Juan\"],\n" +
        "[\"5D5C58\", \"Chicago\"],\n" +
        "[\"5D5E37\", \"Verdigris\"],\n" +
        "[\"5D7747\", \"Dingley\"],\n" +
        "[\"5DA19F\", \"Breaker Bay\"],\n" +
        "[\"5E483E\", \"Kabul\"],\n" +
        "[\"5E5D3B\", \"Hemlock\"],\n" +
        "[\"5F3D26\", \"Irish Coffee\"],\n" +
        "[\"5F5F6E\", \"Mid Gray\"],\n" +
        "[\"5F6672\", \"Shuttle Gray\"],\n" +
        "[\"5FA777\", \"Aqua Forest\"],\n" +
        "[\"5FB3AC\", \"Tradewind\"],\n" +
        "[\"604913\", \"Horses Neck\"],\n" +
        "[\"605B73\", \"Smoky\"],\n" +
        "[\"606E68\", \"Corduroy\"],\n" +
        "[\"6093D1\", \"Danube\"],\n" +
        "[\"612718\", \"Espresso\"],\n" +
        "[\"614051\", \"Eggplant\"],\n" +
        "[\"615D30\", \"Costa Del Sol\"],\n" +
        "[\"61845F\", \"Glade Green\"],\n" +
        "[\"622F30\", \"Buccaneer\"],\n" +
        "[\"623F2D\", \"Quincy\"],\n" +
        "[\"624E9A\", \"Butterfly Bush\"],\n" +
        "[\"625119\", \"West Coast\"],\n" +
        "[\"626649\", \"Finch\"],\n" +
        "[\"639A8F\", \"Patina\"],\n" +
        "[\"63B76C\", \"Fern\"],\n" +
        "[\"6456B7\", \"Blue Violet\"],\n" +
        "[\"646077\", \"Dolphin\"],\n" +
        "[\"646463\", \"Storm Dust\"],\n" +
        "[\"646A54\", \"Siam\"],\n" +
        "[\"646E75\", \"Nevada\"],\n" +
        "[\"6495ED\", \"Cornflower Blue\"],\n" +
        "[\"64CCDB\", \"Viking\"],\n" +
        "[\"65000B\", \"Rosewood\"],\n" +
        "[\"651A14\", \"Cherrywood\"],\n" +
        "[\"652DC1\", \"Purple Heart\"],\n" +
        "[\"657220\", \"Fern Frond\"],\n" +
        "[\"65745D\", \"Willow Grove\"],\n" +
        "[\"65869F\", \"Hoki\"],\n" +
        "[\"660045\", \"Pompadour\"],\n" +
        "[\"660099\", \"Purple\"],\n" +
        "[\"66023C\", \"Tyrian Purple\"],\n" +
        "[\"661010\", \"Dark Tan\"],\n" +
        "[\"66B58F\", \"Silver Tree\"],\n" +
        "[\"66FF00\", \"Bright Green\"],\n" +
        "[\"66FF66\", \"Screamin' Green\"],\n" +
        "[\"67032D\", \"Black Rose\"],\n" +
        "[\"675FA6\", \"Scampi\"],\n" +
        "[\"676662\", \"Ironside Gray\"],\n" +
        "[\"678975\", \"Viridian Green\"],\n" +
        "[\"67A712\", \"Christi\"],\n" +
        "[\"683600\", \"Nutmeg Wood Finish\"],\n" +
        "[\"685558\", \"Zambezi\"],\n" +
        "[\"685E6E\", \"Salt Box\"],\n" +
        "[\"692545\", \"Tawny Port\"],\n" +
        "[\"692D54\", \"Finn\"],\n" +
        "[\"695F62\", \"Scorpion\"],\n" +
        "[\"697E9A\", \"Lynch\"],\n" +
        "[\"6A442E\", \"Spice\"],\n" +
        "[\"6A5D1B\", \"Himalaya\"],\n" +
        "[\"6A6051\", \"Soya Bean\"],\n" +
        "[\"6B2A14\", \"Hairy Heath\"],\n" +
        "[\"6B3FA0\", \"Royal Purple\"],\n" +
        "[\"6B4E31\", \"Shingle Fawn\"],\n" +
        "[\"6B5755\", \"Dorado\"],\n" +
        "[\"6B8BA2\", \"Bermuda Gray\"],\n" +
        "[\"6B8E23\", \"Olive Drab\"],\n" +
        "[\"6C3082\", \"Eminence\"],\n" +
        "[\"6CDAE7\", \"Turquoise Blue\"],\n" +
        "[\"6D0101\", \"Lonestar\"],\n" +
        "[\"6D5E54\", \"Pine Cone\"],\n" +
        "[\"6D6C6C\", \"Dove Gray\"],\n" +
        "[\"6D9292\", \"Juniper\"],\n" +
        "[\"6D92A1\", \"Gothic\"],\n" +
        "[\"6E0902\", \"Red Oxide\"],\n" +
        "[\"6E1D14\", \"Moccaccino\"],\n" +
        "[\"6E4826\", \"Pickled Bean\"],\n" +
        "[\"6E4B26\", \"Dallas\"],\n" +
        "[\"6E6D57\", \"Kokoda\"],\n" +
        "[\"6E7783\", \"Pale Sky\"],\n" +
        "[\"6F440C\", \"Cafe Royale\"],\n" +
        "[\"6F6A61\", \"Flint\"],\n" +
        "[\"6F8E63\", \"Highland\"],\n" +
        "[\"6F9D02\", \"Limeade\"],\n" +
        "[\"6FD0C5\", \"Downy\"],\n" +
        "[\"701C1C\", \"Persian Plum\"],\n" +
        "[\"704214\", \"Sepia\"],\n" +
        "[\"704A07\", \"Antique Bronze\"],\n" +
        "[\"704F50\", \"Ferra\"],\n" +
        "[\"706555\", \"Coffee\"],\n" +
        "[\"708090\", \"Slate Gray\"],\n" +
        "[\"711A00\", \"Cedar Wood Finish\"],\n" +
        "[\"71291D\", \"Metallic Copper\"],\n" +
        "[\"714693\", \"Affair\"],\n" +
        "[\"714AB2\", \"Studio\"],\n" +
        "[\"715D47\", \"Tobacco Brown\"],\n" +
        "[\"716338\", \"Yellow Metal\"],\n" +
        "[\"716B56\", \"Peat\"],\n" +
        "[\"716E10\", \"Olivetone\"],\n" +
        "[\"717486\", \"Storm Gray\"],\n" +
        "[\"718080\", \"Sirocco\"],\n" +
        "[\"71D9E2\", \"Aquamarine Blue\"],\n" +
        "[\"72010F\", \"Venetian Red\"],\n" +
        "[\"724A2F\", \"Old Copper\"],\n" +
        "[\"726D4E\", \"Go Ben\"],\n" +
        "[\"727B89\", \"Raven\"],\n" +
        "[\"731E8F\", \"Seance\"],\n" +
        "[\"734A12\", \"Raw Umber\"],\n" +
        "[\"736C9F\", \"Kimberly\"],\n" +
        "[\"736D58\", \"Crocodile\"],\n" +
        "[\"737829\", \"Crete\"],\n" +
        "[\"738678\", \"Xanadu\"],\n" +
        "[\"74640D\", \"Spicy Mustard\"],\n" +
        "[\"747D63\", \"Limed Ash\"],\n" +
        "[\"747D83\", \"Rolling Stone\"],\n" +
        "[\"748881\", \"Blue Smoke\"],\n" +
        "[\"749378\", \"Laurel\"],\n" +
        "[\"74C365\", \"Mantis\"],\n" +
        "[\"755A57\", \"Russett\"],\n" +
        "[\"7563A8\", \"Deluge\"],\n" +
        "[\"76395D\", \"Cosmic\"],\n" +
        "[\"7666C6\", \"Blue Marguerite\"],\n" +
        "[\"76BD17\", \"Lima\"],\n" +
        "[\"76D7EA\", \"Sky Blue\"],\n" +
        "[\"770F05\", \"Dark Burgundy\"],\n" +
        "[\"771F1F\", \"Crown of Thorns\"],\n" +
        "[\"773F1A\", \"Walnut\"],\n" +
        "[\"776F61\", \"Pablo\"],\n" +
        "[\"778120\", \"Pacifika\"],\n" +
        "[\"779E86\", \"Oxley\"],\n" +
        "[\"77DD77\", \"Pastel Green\"],\n" +
        "[\"780109\", \"Japanese Maple\"],\n" +
        "[\"782D19\", \"Mocha\"],\n" +
        "[\"782F16\", \"Peanut\"],\n" +
        "[\"78866B\", \"Camouflage Green\"],\n" +
        "[\"788A25\", \"Wasabi\"],\n" +
        "[\"788BBA\", \"Ship Cove\"],\n" +
        "[\"78A39C\", \"Sea Nymph\"],\n" +
        "[\"795D4C\", \"Roman Coffee\"],\n" +
        "[\"796878\", \"Old Lavender\"],\n" +
        "[\"796989\", \"Rum\"],\n" +
        "[\"796A78\", \"Fedora\"],\n" +
        "[\"796D62\", \"Sandstone\"],\n" +
        "[\"79DEEC\", \"Spray\"],\n" +
        "[\"7A013A\", \"Siren\"],\n" +
        "[\"7A58C1\", \"Fuchsia Blue\"],\n" +
        "[\"7A7A7A\", \"Boulder\"],\n" +
        "[\"7A89B8\", \"Wild Blue Yonder\"],\n" +
        "[\"7AC488\", \"De York\"],\n" +
        "[\"7B3801\", \"Red Beech\"],\n" +
        "[\"7B3F00\", \"Cinnamon\"],\n" +
        "[\"7B6608\", \"Yukon Gold\"],\n" +
        "[\"7B7874\", \"Tapa\"],\n" +
        "[\"7B7C94\", \"Waterloo \"],\n" +
        "[\"7B8265\", \"Flax Smoke\"],\n" +
        "[\"7B9F80\", \"Amulet\"],\n" +
        "[\"7BA05B\", \"Asparagus\"],\n" +
        "[\"7C1C05\", \"Kenyan Copper\"],\n" +
        "[\"7C7631\", \"Pesto\"],\n" +
        "[\"7C778A\", \"Topaz\"],\n" +
        "[\"7C7B7A\", \"Concord\"],\n" +
        "[\"7C7B82\", \"Jumbo\"],\n" +
        "[\"7C881A\", \"Trendy Green\"],\n" +
        "[\"7CA1A6\", \"Gumbo\"],\n" +
        "[\"7CB0A1\", \"Acapulco\"],\n" +
        "[\"7CB7BB\", \"Neptune\"],\n" +
        "[\"7D2C14\", \"Pueblo\"],\n" +
        "[\"7DA98D\", \"Bay Leaf\"],\n" +
        "[\"7DC8F7\", \"Malibu\"],\n" +
        "[\"7DD8C6\", \"Bermuda\"],\n" +
        "[\"7E3A15\", \"Copper Canyon\"],\n" +
        "[\"7F1734\", \"Claret\"],\n" +
        "[\"7F3A02\", \"Peru Tan\"],\n" +
        "[\"7F626D\", \"Falcon\"],\n" +
        "[\"7F7589\", \"Mobster\"],\n" +
        "[\"7F76D3\", \"Moody Blue\"],\n" +
        "[\"7FFF00\", \"Chartreuse\"],\n" +
        "[\"7FFFD4\", \"Aquamarine\"],\n" +
        "[\"800000\", \"Maroon\"],\n" +
        "[\"800B47\", \"Rose Bud Cherry\"],\n" +
        "[\"801818\", \"Falu Red\"],\n" +
        "[\"80341F\", \"Red Robin\"],\n" +
        "[\"803790\", \"Vivid Violet\"],\n" +
        "[\"80461B\", \"Russet\"],\n" +
        "[\"807E79\", \"Friar Gray\"],\n" +
        "[\"808000\", \"Olive\"],\n" +
        "[\"808080\", \"Gray\"],\n" +
        "[\"80B3AE\", \"Gulf Stream\"],\n" +
        "[\"80B3C4\", \"Glacier\"],\n" +
        "[\"80CCEA\", \"Seagull\"],\n" +
        "[\"81422C\", \"Nutmeg\"],\n" +
        "[\"816E71\", \"Spicy Pink\"],\n" +
        "[\"817377\", \"Empress\"],\n" +
        "[\"819885\", \"Spanish Green\"],\n" +
        "[\"826F65\", \"Sand Dune\"],\n" +
        "[\"828685\", \"Gunsmoke\"],\n" +
        "[\"828F72\", \"Battleship Gray\"],\n" +
        "[\"831923\", \"Merlot\"],\n" +
        "[\"837050\", \"Shadow\"],\n" +
        "[\"83AA5D\", \"Chelsea Cucumber\"],\n" +
        "[\"83D0C6\", \"Monte Carlo\"],\n" +
        "[\"843179\", \"Plum\"],\n" +
        "[\"84A0A0\", \"Granny Smith\"],\n" +
        "[\"8581D9\", \"Chetwode Blue\"],\n" +
        "[\"858470\", \"Bandicoot\"],\n" +
        "[\"859FAF\", \"Bali Hai\"],\n" +
        "[\"85C4CC\", \"Half Baked\"],\n" +
        "[\"860111\", \"Red Devil\"],\n" +
        "[\"863C3C\", \"Lotus\"],\n" +
        "[\"86483C\", \"Ironstone\"],\n" +
        "[\"864D1E\", \"Bull Shot\"],\n" +
        "[\"86560A\", \"Rusty Nail\"],\n" +
        "[\"868974\", \"Bitter\"],\n" +
        "[\"86949F\", \"Regent Gray\"],\n" +
        "[\"871550\", \"Disco\"],\n" +
        "[\"87756E\", \"Americano\"],\n" +
        "[\"877C7B\", \"Hurricane\"],\n" +
        "[\"878D91\", \"Oslo Gray\"],\n" +
        "[\"87AB39\", \"Sushi\"],\n" +
        "[\"885342\", \"Spicy Mix\"],\n" +
        "[\"886221\", \"Kumera\"],\n" +
        "[\"888387\", \"Suva Gray\"],\n" +
        "[\"888D65\", \"Avocado\"],\n" +
        "[\"893456\", \"Camelot\"],\n" +
        "[\"893843\", \"Solid Pink\"],\n" +
        "[\"894367\", \"Cannon Pink\"],\n" +
        "[\"897D6D\", \"Makara\"],\n" +
        "[\"8A3324\", \"Burnt Umber\"],\n" +
        "[\"8A73D6\", \"True V\"],\n" +
        "[\"8A8360\", \"Clay Creek\"],\n" +
        "[\"8A8389\", \"Monsoon\"],\n" +
        "[\"8A8F8A\", \"Stack\"],\n" +
        "[\"8AB9F1\", \"Jordy Blue\"],\n" +
        "[\"8B00FF\", \"Electric Violet\"],\n" +
        "[\"8B0723\", \"Monarch\"],\n" +
        "[\"8B6B0B\", \"Corn Harvest\"],\n" +
        "[\"8B8470\", \"Olive Haze\"],\n" +
        "[\"8B847E\", \"Schooner\"],\n" +
        "[\"8B8680\", \"Natural Gray\"],\n" +
        "[\"8B9C90\", \"Mantle\"],\n" +
        "[\"8B9FEE\", \"Portage\"],\n" +
        "[\"8BA690\", \"Envy\"],\n" +
        "[\"8BA9A5\", \"Cascade\"],\n" +
        "[\"8BE6D8\", \"Riptide\"],\n" +
        "[\"8C055E\", \"Cardinal Pink\"],\n" +
        "[\"8C472F\", \"Mule Fawn\"],\n" +
        "[\"8C5738\", \"Potters Clay\"],\n" +
        "[\"8C6495\", \"Trendy Pink\"],\n" +
        "[\"8D0226\", \"Paprika\"],\n" +
        "[\"8D3D38\", \"Sanguine Brown\"],\n" +
        "[\"8D3F3F\", \"Tosca\"],\n" +
        "[\"8D7662\", \"Cement\"],\n" +
        "[\"8D8974\", \"Granite Green\"],\n" +
        "[\"8D90A1\", \"Manatee\"],\n" +
        "[\"8DA8CC\", \"Polo Blue\"],\n" +
        "[\"8E0000\", \"Red Berry\"],\n" +
        "[\"8E4D1E\", \"Rope\"],\n" +
        "[\"8E6F70\", \"Opium\"],\n" +
        "[\"8E775E\", \"Domino\"],\n" +
        "[\"8E8190\", \"Mamba\"],\n" +
        "[\"8EABC1\", \"Nepal\"],\n" +
        "[\"8F021C\", \"Pohutukawa\"],\n" +
        "[\"8F3E33\", \"El Salva\"],\n" +
        "[\"8F4B0E\", \"Korma\"],\n" +
        "[\"8F8176\", \"Squirrel\"],\n" +
        "[\"8FD6B4\", \"Vista Blue\"],\n" +
        "[\"900020\", \"Burgundy\"],\n" +
        "[\"901E1E\", \"Old Brick\"],\n" +
        "[\"907874\", \"Hemp\"],\n" +
        "[\"907B71\", \"Almond Frost\"],\n" +
        "[\"908D39\", \"Sycamore\"],\n" +
        "[\"92000A\", \"Sangria\"],\n" +
        "[\"924321\", \"Cumin\"],\n" +
        "[\"926F5B\", \"Beaver\"],\n" +
        "[\"928573\", \"Stonewall\"],\n" +
        "[\"928590\", \"Venus\"],\n" +
        "[\"9370DB\", \"Medium Purple\"],\n" +
        "[\"93CCEA\", \"Cornflower\"],\n" +
        "[\"93DFB8\", \"Algae Green\"],\n" +
        "[\"944747\", \"Copper Rust\"],\n" +
        "[\"948771\", \"Arrowtown\"],\n" +
        "[\"950015\", \"Scarlett\"],\n" +
        "[\"956387\", \"Strikemaster\"],\n" +
        "[\"959396\", \"Mountain Mist\"],\n" +
        "[\"960018\", \"Carmine\"],\n" +
        "[\"964B00\", \"Brown\"],\n" +
        "[\"967059\", \"Leather\"],\n" +
        "[\"9678B6\", \"Purple Mountain's Majesty\"],\n" +
        "[\"967BB6\", \"Lavender Purple\"],\n" +
        "[\"96A8A1\", \"Pewter\"],\n" +
        "[\"96BBAB\", \"Summer Green\"],\n" +
        "[\"97605D\", \"Au Chico\"],\n" +
        "[\"9771B5\", \"Wisteria\"],\n" +
        "[\"97CD2D\", \"Atlantis\"],\n" +
        "[\"983D61\", \"Vin Rouge\"],\n" +
        "[\"9874D3\", \"Lilac Bush\"],\n" +
        "[\"98777B\", \"Bazaar\"],\n" +
        "[\"98811B\", \"Hacienda\"],\n" +
        "[\"988D77\", \"Pale Oyster\"],\n" +
        "[\"98FF98\", \"Mint Green\"],\n" +
        "[\"990066\", \"Fresh Eggplant\"],\n" +
        "[\"991199\", \"Violet Eggplant\"],\n" +
        "[\"991613\", \"Tamarillo\"],\n" +
        "[\"991B07\", \"Totem Pole\"],\n" +
        "[\"996666\", \"Copper Rose\"],\n" +
        "[\"9966CC\", \"Amethyst\"],\n" +
        "[\"997A8D\", \"Mountbatten Pink\"],\n" +
        "[\"9999CC\", \"Blue Bell\"],\n" +
        "[\"9A3820\", \"Prairie Sand\"],\n" +
        "[\"9A6E61\", \"Toast\"],\n" +
        "[\"9A9577\", \"Gurkha\"],\n" +
        "[\"9AB973\", \"Olivine\"],\n" +
        "[\"9AC2B8\", \"Shadow Green\"],\n" +
        "[\"9B4703\", \"Oregon\"],\n" +
        "[\"9B9E8F\", \"Lemon Grass\"],\n" +
        "[\"9C3336\", \"Stiletto\"],\n" +
        "[\"9D5616\", \"Hawaiian Tan\"],\n" +
        "[\"9DACB7\", \"Gull Gray\"],\n" +
        "[\"9DC209\", \"Pistachio\"],\n" +
        "[\"9DE093\", \"Granny Smith Apple\"],\n" +
        "[\"9DE5FF\", \"Anakiwa\"],\n" +
        "[\"9E5302\", \"Chelsea Gem\"],\n" +
        "[\"9E5B40\", \"Sepia Skin\"],\n" +
        "[\"9EA587\", \"Sage\"],\n" +
        "[\"9EA91F\", \"Citron\"],\n" +
        "[\"9EB1CD\", \"Rock Blue\"],\n" +
        "[\"9EDEE0\", \"Morning Glory\"],\n" +
        "[\"9F381D\", \"Cognac\"],\n" +
        "[\"9F821C\", \"Reef Gold\"],\n" +
        "[\"9F9F9C\", \"Star Dust\"],\n" +
        "[\"9FA0B1\", \"Santas Gray\"],\n" +
        "[\"9FD7D3\", \"Sinbad\"],\n" +
        "[\"9FDD8C\", \"Feijoa\"],\n" +
        "[\"A02712\", \"Tabasco\"],\n" +
        "[\"A1750D\", \"Buttered Rum\"],\n" +
        "[\"A1ADB5\", \"Hit Gray\"],\n" +
        "[\"A1C50A\", \"Citrus\"],\n" +
        "[\"A1DAD7\", \"Aqua Island\"],\n" +
        "[\"A1E9DE\", \"Water Leaf\"],\n" +
        "[\"A2006D\", \"Flirt\"],\n" +
        "[\"A23B6C\", \"Rouge\"],\n" +
        "[\"A26645\", \"Cape Palliser\"],\n" +
        "[\"A2AAB3\", \"Gray Chateau\"],\n" +
        "[\"A2AEAB\", \"Edward\"],\n" +
        "[\"A3807B\", \"Pharlap\"],\n" +
        "[\"A397B4\", \"Amethyst Smoke\"],\n" +
        "[\"A3E3ED\", \"Blizzard Blue\"],\n" +
        "[\"A4A49D\", \"Delta\"],\n" +
        "[\"A4A6D3\", \"Wistful\"],\n" +
        "[\"A4AF6E\", \"Green Smoke\"],\n" +
        "[\"A50B5E\", \"Jazzberry Jam\"],\n" +
        "[\"A59B91\", \"Zorba\"],\n" +
        "[\"A5CB0C\", \"Bahia\"],\n" +
        "[\"A62F20\", \"Roof Terracotta\"],\n" +
        "[\"A65529\", \"Paarl\"],\n" +
        "[\"A68B5B\", \"Barley Corn\"],\n" +
        "[\"A69279\", \"Donkey Brown\"],\n" +
        "[\"A6A29A\", \"Dawn\"],\n" +
        "[\"A72525\", \"Mexican Red\"],\n" +
        "[\"A7882C\", \"Luxor Gold\"],\n" +
        "[\"A85307\", \"Rich Gold\"],\n" +
        "[\"A86515\", \"Reno Sand\"],\n" +
        "[\"A86B6B\", \"Coral Tree\"],\n" +
        "[\"A8989B\", \"Dusty Gray\"],\n" +
        "[\"A899E6\", \"Dull Lavender\"],\n" +
        "[\"A8A589\", \"Tallow\"],\n" +
        "[\"A8AE9C\", \"Bud\"],\n" +
        "[\"A8AF8E\", \"Locust\"],\n" +
        "[\"A8BD9F\", \"Norway\"],\n" +
        "[\"A8E3BD\", \"Chinook\"],\n" +
        "[\"A9A491\", \"Gray Olive\"],\n" +
        "[\"A9ACB6\", \"Aluminium\"],\n" +
        "[\"A9B2C3\", \"Cadet Blue\"],\n" +
        "[\"A9B497\", \"Schist\"],\n" +
        "[\"A9BDBF\", \"Tower Gray\"],\n" +
        "[\"A9BEF2\", \"Perano\"],\n" +
        "[\"A9C6C2\", \"Opal\"],\n" +
        "[\"AA375A\", \"Night Shadz\"],\n" +
        "[\"AA4203\", \"Fire\"],\n" +
        "[\"AA8B5B\", \"Muesli\"],\n" +
        "[\"AA8D6F\", \"Sandal\"],\n" +
        "[\"AAA5A9\", \"Shady Lady\"],\n" +
        "[\"AAA9CD\", \"Logan\"],\n" +
        "[\"AAABB7\", \"Spun Pearl\"],\n" +
        "[\"AAD6E6\", \"Regent St Blue\"],\n" +
        "[\"AAF0D1\", \"Magic Mint\"],\n" +
        "[\"AB0563\", \"Lipstick\"],\n" +
        "[\"AB3472\", \"Royal Heath\"],\n" +
        "[\"AB917A\", \"Sandrift\"],\n" +
        "[\"ABA0D9\", \"Cold Purple\"],\n" +
        "[\"ABA196\", \"Bronco\"],\n" +
        "[\"AC8A56\", \"Limed Oak\"],\n" +
        "[\"AC91CE\", \"East Side\"],\n" +
        "[\"AC9E22\", \"Lemon Ginger\"],\n" +
        "[\"ACA494\", \"Napa\"],\n" +
        "[\"ACA586\", \"Hillary\"],\n" +
        "[\"ACA59F\", \"Cloudy\"],\n" +
        "[\"ACACAC\", \"Silver Chalice\"],\n" +
        "[\"ACB78E\", \"Swamp Green\"],\n" +
        "[\"ACCBB1\", \"Spring Rain\"],\n" +
        "[\"ACDD4D\", \"Conifer\"],\n" +
        "[\"ACE1AF\", \"Celadon\"],\n" +
        "[\"AD781B\", \"Mandalay\"],\n" +
        "[\"ADBED1\", \"Casper\"],\n" +
        "[\"ADDFAD\", \"Moss Green\"],\n" +
        "[\"ADE6C4\", \"Padua\"],\n" +
        "[\"ADFF2F\", \"Green Yellow\"],\n" +
        "[\"AE4560\", \"Hippie Pink\"],\n" +
        "[\"AE6020\", \"Desert\"],\n" +
        "[\"AE809E\", \"Bouquet\"],\n" +
        "[\"AF4035\", \"Medium Carmine\"],\n" +
        "[\"AF4D43\", \"Apple Blossom\"],\n" +
        "[\"AF593E\", \"Brown Rust\"],\n" +
        "[\"AF8751\", \"Driftwood\"],\n" +
        "[\"AF8F2C\", \"Alpine\"],\n" +
        "[\"AF9F1C\", \"Lucky\"],\n" +
        "[\"AFA09E\", \"Martini\"],\n" +
        "[\"AFB1B8\", \"Bombay\"],\n" +
        "[\"AFBDD9\", \"Pigeon Post\"],\n" +
        "[\"B04C6A\", \"Cadillac\"],\n" +
        "[\"B05D54\", \"Matrix\"],\n" +
        "[\"B05E81\", \"Tapestry\"],\n" +
        "[\"B06608\", \"Mai Tai\"],\n" +
        "[\"B09A95\", \"Del Rio\"],\n" +
        "[\"B0E0E6\", \"Powder Blue\"],\n" +
        "[\"B0E313\", \"Inch Worm\"],\n" +
        "[\"B10000\", \"Bright Red\"],\n" +
        "[\"B14A0B\", \"Vesuvius\"],\n" +
        "[\"B1610B\", \"Pumpkin Skin\"],\n" +
        "[\"B16D52\", \"Santa Fe\"],\n" +
        "[\"B19461\", \"Teak\"],\n" +
        "[\"B1E2C1\", \"Fringy Flower\"],\n" +
        "[\"B1F4E7\", \"Ice Cold\"],\n" +
        "[\"B20931\", \"Shiraz\"],\n" +
        "[\"B2A1EA\", \"Biloba Flower\"],\n" +
        "[\"B32D29\", \"Tall Poppy\"],\n" +
        "[\"B35213\", \"Fiery Orange\"],\n" +
        "[\"B38007\", \"Hot Toddy\"],\n" +
        "[\"B3AF95\", \"Taupe Gray\"],\n" +
        "[\"B3C110\", \"La Rioja\"],\n" +
        "[\"B43332\", \"Well Read\"],\n" +
        "[\"B44668\", \"Blush\"],\n" +
        "[\"B4CFD3\", \"Jungle Mist\"],\n" +
        "[\"B57281\", \"Turkish Rose\"],\n" +
        "[\"B57EDC\", \"Lavender\"],\n" +
        "[\"B5A27F\", \"Mongoose\"],\n" +
        "[\"B5B35C\", \"Olive Green\"],\n" +
        "[\"B5D2CE\", \"Jet Stream\"],\n" +
        "[\"B5ECDF\", \"Cruise\"],\n" +
        "[\"B6316C\", \"Hibiscus\"],\n" +
        "[\"B69D98\", \"Thatch\"],\n" +
        "[\"B6B095\", \"Heathered Gray\"],\n" +
        "[\"B6BAA4\", \"Eagle\"],\n" +
        "[\"B6D1EA\", \"Spindle\"],\n" +
        "[\"B6D3BF\", \"Gum Leaf\"],\n" +
        "[\"B7410E\", \"Rust\"],\n" +
        "[\"B78E5C\", \"Muddy Waters\"],\n" +
        "[\"B7A214\", \"Sahara\"],\n" +
        "[\"B7A458\", \"Husk\"],\n" +
        "[\"B7B1B1\", \"Nobel\"],\n" +
        "[\"B7C3D0\", \"Heather\"],\n" +
        "[\"B7F0BE\", \"Madang\"],\n" +
        "[\"B81104\", \"Milano Red\"],\n" +
        "[\"B87333\", \"Copper\"],\n" +
        "[\"B8B56A\", \"Gimblet\"],\n" +
        "[\"B8C1B1\", \"Green Spring\"],\n" +
        "[\"B8C25D\", \"Celery\"],\n" +
        "[\"B8E0F9\", \"Sail\"],\n" +
        "[\"B94E48\", \"Chestnut\"],\n" +
        "[\"B95140\", \"Crail\"],\n" +
        "[\"B98D28\", \"Marigold\"],\n" +
        "[\"B9C46A\", \"Wild Willow\"],\n" +
        "[\"B9C8AC\", \"Rainee\"],\n" +
        "[\"BA0101\", \"Guardsman Red\"],\n" +
        "[\"BA450C\", \"Rock Spray\"],\n" +
        "[\"BA6F1E\", \"Bourbon\"],\n" +
        "[\"BA7F03\", \"Pirate Gold\"],\n" +
        "[\"BAB1A2\", \"Nomad\"],\n" +
        "[\"BAC7C9\", \"Submarine\"],\n" +
        "[\"BAEEF9\", \"Charlotte\"],\n" +
        "[\"BB3385\", \"Medium Red Violet\"],\n" +
        "[\"BB8983\", \"Brandy Rose\"],\n" +
        "[\"BBD009\", \"Rio Grande\"],\n" +
        "[\"BBD7C1\", \"Surf\"],\n" +
        "[\"BCC9C2\", \"Powder Ash\"],\n" +
        "[\"BD5E2E\", \"Tuscany\"],\n" +
        "[\"BD978E\", \"Quicksand\"],\n" +
        "[\"BDB1A8\", \"Silk\"],\n" +
        "[\"BDB2A1\", \"Malta\"],\n" +
        "[\"BDB3C7\", \"Chatelle\"],\n" +
        "[\"BDBBD7\", \"Lavender Gray\"],\n" +
        "[\"BDBDC6\", \"French Gray\"],\n" +
        "[\"BDC8B3\", \"Clay Ash\"],\n" +
        "[\"BDC9CE\", \"Loblolly\"],\n" +
        "[\"BDEDFD\", \"French Pass\"],\n" +
        "[\"BEA6C3\", \"London Hue\"],\n" +
        "[\"BEB5B7\", \"Pink Swan\"],\n" +
        "[\"BEDE0D\", \"Fuego\"],\n" +
        "[\"BF5500\", \"Rose of Sharon\"],\n" +
        "[\"BFB8B0\", \"Tide\"],\n" +
        "[\"BFBED8\", \"Blue Haze\"],\n" +
        "[\"BFC1C2\", \"Silver Sand\"],\n" +
        "[\"BFC921\", \"Key Lime Pie\"],\n" +
        "[\"BFDBE2\", \"Ziggurat\"],\n" +
        "[\"BFFF00\", \"Lime\"],\n" +
        "[\"C02B18\", \"Thunderbird\"],\n" +
        "[\"C04737\", \"Mojo\"],\n" +
        "[\"C08081\", \"Old Rose\"],\n" +
        "[\"C0C0C0\", \"Silver\"],\n" +
        "[\"C0D3B9\", \"Pale Leaf\"],\n" +
        "[\"C0D8B6\", \"Pixie Green\"],\n" +
        "[\"C1440E\", \"Tia Maria\"],\n" +
        "[\"C154C1\", \"Fuchsia Pink\"],\n" +
        "[\"C1A004\", \"Buddha Gold\"],\n" +
        "[\"C1B7A4\", \"Bison Hide\"],\n" +
        "[\"C1BAB0\", \"Tea\"],\n" +
        "[\"C1BECD\", \"Gray Suit\"],\n" +
        "[\"C1D7B0\", \"Sprout\"],\n" +
        "[\"C1F07C\", \"Sulu\"],\n" +
        "[\"C26B03\", \"Indochine\"],\n" +
        "[\"C2955D\", \"Twine\"],\n" +
        "[\"C2BDB6\", \"Cotton Seed\"],\n" +
        "[\"C2CAC4\", \"Pumice\"],\n" +
        "[\"C2E8E5\", \"Jagged Ice\"],\n" +
        "[\"C32148\", \"Maroon Flush\"],\n" +
        "[\"C3B091\", \"Indian Khaki\"],\n" +
        "[\"C3BFC1\", \"Pale Slate\"],\n" +
        "[\"C3C3BD\", \"Gray Nickel\"],\n" +
        "[\"C3CDE6\", \"Periwinkle Gray\"],\n" +
        "[\"C3D1D1\", \"Tiara\"],\n" +
        "[\"C3DDF9\", \"Tropical Blue\"],\n" +
        "[\"C41E3A\", \"Cardinal\"],\n" +
        "[\"C45655\", \"Fuzzy Wuzzy Brown\"],\n" +
        "[\"C45719\", \"Orange Roughy\"],\n" +
        "[\"C4C4BC\", \"Mist Gray\"],\n" +
        "[\"C4D0B0\", \"Coriander\"],\n" +
        "[\"C4F4EB\", \"Mint Tulip\"],\n" +
        "[\"C54B8C\", \"Mulberry\"],\n" +
        "[\"C59922\", \"Nugget\"],\n" +
        "[\"C5994B\", \"Tussock\"],\n" +
        "[\"C5DBCA\", \"Sea Mist\"],\n" +
        "[\"C5E17A\", \"Yellow Green\"],\n" +
        "[\"C62D42\", \"Brick Red\"],\n" +
        "[\"C6726B\", \"Contessa\"],\n" +
        "[\"C69191\", \"Oriental Pink\"],\n" +
        "[\"C6A84B\", \"Roti\"],\n" +
        "[\"C6C3B5\", \"Ash\"],\n" +
        "[\"C6C8BD\", \"Kangaroo\"],\n" +
        "[\"C6E610\", \"Las Palmas\"],\n" +
        "[\"C7031E\", \"Monza\"],\n" +
        "[\"C71585\", \"Red Violet\"],\n" +
        "[\"C7BCA2\", \"Coral Reef\"],\n" +
        "[\"C7C1FF\", \"Melrose\"],\n" +
        "[\"C7C4BF\", \"Cloud\"],\n" +
        "[\"C7C9D5\", \"Ghost\"],\n" +
        "[\"C7CD90\", \"Pine Glade\"],\n" +
        "[\"C7DDE5\", \"Botticelli\"],\n" +
        "[\"C88A65\", \"Antique Brass\"],\n" +
        "[\"C8A2C8\", \"Lilac\"],\n" +
        "[\"C8A528\", \"Hokey Pokey\"],\n" +
        "[\"C8AABF\", \"Lily\"],\n" +
        "[\"C8B568\", \"Laser\"],\n" +
        "[\"C8E3D7\", \"Edgewater\"],\n" +
        "[\"C96323\", \"Piper\"],\n" +
        "[\"C99415\", \"Pizza\"],\n" +
        "[\"C9A0DC\", \"Light Wisteria\"],\n" +
        "[\"C9B29B\", \"Rodeo Dust\"],\n" +
        "[\"C9B35B\", \"Sundance\"],\n" +
        "[\"C9B93B\", \"Earls Green\"],\n" +
        "[\"C9C0BB\", \"Silver Rust\"],\n" +
        "[\"C9D9D2\", \"Conch\"],\n" +
        "[\"C9FFA2\", \"Reef\"],\n" +
        "[\"C9FFE5\", \"Aero Blue\"],\n" +
        "[\"CA3435\", \"Flush Mahogany\"],\n" +
        "[\"CABB48\", \"Turmeric\"],\n" +
        "[\"CADCD4\", \"Paris White\"],\n" +
        "[\"CAE00D\", \"Bitter Lemon\"],\n" +
        "[\"CAE6DA\", \"Skeptic\"],\n" +
        "[\"CB8FA9\", \"Viola\"],\n" +
        "[\"CBCAB6\", \"Foggy Gray\"],\n" +
        "[\"CBD3B0\", \"Green Mist\"],\n" +
        "[\"CBDBD6\", \"Nebula\"],\n" +
        "[\"CC3333\", \"Persian Red\"],\n" +
        "[\"CC5500\", \"Burnt Orange\"],\n" +
        "[\"CC7722\", \"Ochre\"],\n" +
        "[\"CC8899\", \"Puce\"],\n" +
        "[\"CCCAA8\", \"Thistle Green\"],\n" +
        "[\"CCCCFF\", \"Periwinkle\"],\n" +
        "[\"CCFF00\", \"Electric Lime\"],\n" +
        "[\"CD5700\", \"Tenn\"],\n" +
        "[\"CD5C5C\", \"Chestnut Rose\"],\n" +
        "[\"CD8429\", \"Brandy Punch\"],\n" +
        "[\"CDF4FF\", \"Onahau\"],\n" +
        "[\"CEB98F\", \"Sorrell Brown\"],\n" +
        "[\"CEBABA\", \"Cold Turkey\"],\n" +
        "[\"CEC291\", \"Yuma\"],\n" +
        "[\"CEC7A7\", \"Chino\"],\n" +
        "[\"CFA39D\", \"Eunry\"],\n" +
        "[\"CFB53B\", \"Old Gold\"],\n" +
        "[\"CFDCCF\", \"Tasman\"],\n" +
        "[\"CFE5D2\", \"Surf Crest\"],\n" +
        "[\"CFF9F3\", \"Humming Bird\"],\n" +
        "[\"CFFAF4\", \"Scandal\"],\n" +
        "[\"D05F04\", \"Red Stage\"],\n" +
        "[\"D06DA1\", \"Hopbush\"],\n" +
        "[\"D07D12\", \"Meteor\"],\n" +
        "[\"D0BEF8\", \"Perfume\"],\n" +
        "[\"D0C0E5\", \"Prelude\"],\n" +
        "[\"D0F0C0\", \"Tea Green\"],\n" +
        "[\"D18F1B\", \"Geebung\"],\n" +
        "[\"D1BEA8\", \"Vanilla\"],\n" +
        "[\"D1C6B4\", \"Soft Amber\"],\n" +
        "[\"D1D2CA\", \"Celeste\"],\n" +
        "[\"D1D2DD\", \"Mischka\"],\n" +
        "[\"D1E231\", \"Pear\"],\n" +
        "[\"D2691E\", \"Hot Cinnamon\"],\n" +
        "[\"D27D46\", \"Raw Sienna\"],\n" +
        "[\"D29EAA\", \"Careys Pink\"],\n" +
        "[\"D2B48C\", \"Tan\"],\n" +
        "[\"D2DA97\", \"Deco\"],\n" +
        "[\"D2F6DE\", \"Blue Romance\"],\n" +
        "[\"D2F8B0\", \"Gossip\"],\n" +
        "[\"D3CBBA\", \"Sisal\"],\n" +
        "[\"D3CDC5\", \"Swirl\"],\n" +
        "[\"D47494\", \"Charm\"],\n" +
        "[\"D4B6AF\", \"Clam Shell\"],\n" +
        "[\"D4BF8D\", \"Straw\"],\n" +
        "[\"D4C4A8\", \"Akaroa\"],\n" +
        "[\"D4CD16\", \"Bird Flower\"],\n" +
        "[\"D4D7D9\", \"Iron\"],\n" +
        "[\"D4DFE2\", \"Geyser\"],\n" +
        "[\"D4E2FC\", \"Hawkes Blue\"],\n" +
        "[\"D54600\", \"Grenadier\"],\n" +
        "[\"D591A4\", \"Can Can\"],\n" +
        "[\"D59A6F\", \"Whiskey\"],\n" +
        "[\"D5D195\", \"Winter Hazel\"],\n" +
        "[\"D5F6E3\", \"Granny Apple\"],\n" +
        "[\"D69188\", \"My Pink\"],\n" +
        "[\"D6C562\", \"Tacha\"],\n" +
        "[\"D6CEF6\", \"Moon Raker\"],\n" +
        "[\"D6D6D1\", \"Quill Gray\"],\n" +
        "[\"D6FFDB\", \"Snowy Mint\"],\n" +
        "[\"D7837F\", \"New York Pink\"],\n" +
        "[\"D7C498\", \"Pavlova\"],\n" +
        "[\"D7D0FF\", \"Fog\"],\n" +
        "[\"D84437\", \"Valencia\"],\n" +
        "[\"D87C63\", \"Japonica\"],\n" +
        "[\"D8BFD8\", \"Thistle\"],\n" +
        "[\"D8C2D5\", \"Maverick\"],\n" +
        "[\"D8FCFA\", \"Foam\"],\n" +
        "[\"D94972\", \"Cabaret\"],\n" +
        "[\"D99376\", \"Burning Sand\"],\n" +
        "[\"D9B99B\", \"Cameo\"],\n" +
        "[\"D9D6CF\", \"Timberwolf\"],\n" +
        "[\"D9DCC1\", \"Tana\"],\n" +
        "[\"D9E4F5\", \"Link Water\"],\n" +
        "[\"D9F7FF\", \"Mabel\"],\n" +
        "[\"DA3287\", \"Cerise\"],\n" +
        "[\"DA5B38\", \"Flame Pea\"],\n" +
        "[\"DA6304\", \"Bamboo\"],\n" +
        "[\"DA6A41\", \"Red Damask\"],\n" +
        "[\"DA70D6\", \"Orchid\"],\n" +
        "[\"DA8A67\", \"Copperfield\"],\n" +
        "[\"DAA520\", \"Golden Grass\"],\n" +
        "[\"DAECD6\", \"Zanah\"],\n" +
        "[\"DAF4F0\", \"Iceberg\"],\n" +
        "[\"DAFAFF\", \"Oyster Bay\"],\n" +
        "[\"DB5079\", \"Cranberry\"],\n" +
        "[\"DB9690\", \"Petite Orchid\"],\n" +
        "[\"DB995E\", \"Di Serria\"],\n" +
        "[\"DBDBDB\", \"Alto\"],\n" +
        "[\"DBFFF8\", \"Frosted Mint\"],\n" +
        "[\"DC143C\", \"Crimson\"],\n" +
        "[\"DC4333\", \"Punch\"],\n" +
        "[\"DCB20C\", \"Galliano\"],\n" +
        "[\"DCB4BC\", \"Blossom\"],\n" +
        "[\"DCD747\", \"Wattle\"],\n" +
        "[\"DCD9D2\", \"Westar\"],\n" +
        "[\"DCDDCC\", \"Moon Mist\"],\n" +
        "[\"DCEDB4\", \"Caper\"],\n" +
        "[\"DCF0EA\", \"Swans Down\"],\n" +
        "[\"DDD6D5\", \"Swiss Coffee\"],\n" +
        "[\"DDF9F1\", \"White Ice\"],\n" +
        "[\"DE3163\", \"Cerise Red\"],\n" +
        "[\"DE6360\", \"Roman\"],\n" +
        "[\"DEA681\", \"Tumbleweed\"],\n" +
        "[\"DEBA13\", \"Gold Tips\"],\n" +
        "[\"DEC196\", \"Brandy\"],\n" +
        "[\"DECBC6\", \"Wafer\"],\n" +
        "[\"DED4A4\", \"Sapling\"],\n" +
        "[\"DED717\", \"Barberry\"],\n" +
        "[\"DEE5C0\", \"Beryl Green\"],\n" +
        "[\"DEF5FF\", \"Pattens Blue\"],\n" +
        "[\"DF73FF\", \"Heliotrope\"],\n" +
        "[\"DFBE6F\", \"Apache\"],\n" +
        "[\"DFCD6F\", \"Chenin\"],\n" +
        "[\"DFCFDB\", \"Lola\"],\n" +
        "[\"DFECDA\", \"Willow Brook\"],\n" +
        "[\"DFFF00\", \"Chartreuse Yellow\"],\n" +
        "[\"E0B0FF\", \"Mauve\"],\n" +
        "[\"E0B646\", \"Anzac\"],\n" +
        "[\"E0B974\", \"Harvest Gold\"],\n" +
        "[\"E0C095\", \"Calico\"],\n" +
        "[\"E0FFFF\", \"Baby Blue\"],\n" +
        "[\"E16865\", \"Sunglo\"],\n" +
        "[\"E1BC64\", \"Equator\"],\n" +
        "[\"E1C0C8\", \"Pink Flare\"],\n" +
        "[\"E1E6D6\", \"Periglacial Blue\"],\n" +
        "[\"E1EAD4\", \"Kidnapper\"],\n" +
        "[\"E1F6E8\", \"Tara\"],\n" +
        "[\"E25465\", \"Mandy\"],\n" +
        "[\"E2725B\", \"Terracotta\"],\n" +
        "[\"E28913\", \"Golden Bell\"],\n" +
        "[\"E292C0\", \"Shocking\"],\n" +
        "[\"E29418\", \"Dixie\"],\n" +
        "[\"E29CD2\", \"Light Orchid\"],\n" +
        "[\"E2D8ED\", \"Snuff\"],\n" +
        "[\"E2EBED\", \"Mystic\"],\n" +
        "[\"E2F3EC\", \"Apple Green\"],\n" +
        "[\"E30B5C\", \"Razzmatazz\"],\n" +
        "[\"E32636\", \"Alizarin Crimson\"],\n" +
        "[\"E34234\", \"Cinnabar\"],\n" +
        "[\"E3BEBE\", \"Cavern Pink\"],\n" +
        "[\"E3F5E1\", \"Peppermint\"],\n" +
        "[\"E3F988\", \"Mindaro\"],\n" +
        "[\"E47698\", \"Deep Blush\"],\n" +
        "[\"E49B0F\", \"Gamboge\"],\n" +
        "[\"E4C2D5\", \"Melanie\"],\n" +
        "[\"E4CFDE\", \"Twilight\"],\n" +
        "[\"E4D1C0\", \"Bone\"],\n" +
        "[\"E4D422\", \"Sunflower\"],\n" +
        "[\"E4D5B7\", \"Grain Brown\"],\n" +
        "[\"E4D69B\", \"Zombie\"],\n" +
        "[\"E4F6E7\", \"Frostee\"],\n" +
        "[\"E4FFD1\", \"Snow Flurry\"],\n" +
        "[\"E52B50\", \"Amaranth\"],\n" +
        "[\"E5841B\", \"Zest\"],\n" +
        "[\"E5CCC9\", \"Dust Storm\"],\n" +
        "[\"E5D7BD\", \"Stark White\"],\n" +
        "[\"E5D8AF\", \"Hampton\"],\n" +
        "[\"E5E0E1\", \"Bon Jour\"],\n" +
        "[\"E5E5E5\", \"Mercury\"],\n" +
        "[\"E5F9F6\", \"Polar\"],\n" +
        "[\"E64E03\", \"Trinidad\"],\n" +
        "[\"E6BE8A\", \"Gold Sand\"],\n" +
        "[\"E6BEA5\", \"Cashmere\"],\n" +
        "[\"E6D7B9\", \"Double Spanish White\"],\n" +
        "[\"E6E4D4\", \"Satin Linen\"],\n" +
        "[\"E6F2EA\", \"Harp\"],\n" +
        "[\"E6F8F3\", \"Off Green\"],\n" +
        "[\"E6FFE9\", \"Hint of Green\"],\n" +
        "[\"E6FFFF\", \"Tranquil\"],\n" +
        "[\"E77200\", \"Mango Tango\"],\n" +
        "[\"E7730A\", \"Christine\"],\n" +
        "[\"E79F8C\", \"Tonys Pink\"],\n" +
        "[\"E79FC4\", \"Kobi\"],\n" +
        "[\"E7BCB4\", \"Rose Fog\"],\n" +
        "[\"E7BF05\", \"Corn\"],\n" +
        "[\"E7CD8C\", \"Putty\"],\n" +
        "[\"E7ECE6\", \"Gray Nurse\"],\n" +
        "[\"E7F8FF\", \"Lily White\"],\n" +
        "[\"E7FEFF\", \"Bubbles\"],\n" +
        "[\"E89928\", \"Fire Bush\"],\n" +
        "[\"E8B9B3\", \"Shilo\"],\n" +
        "[\"E8E0D5\", \"Pearl Bush\"],\n" +
        "[\"E8EBE0\", \"Green White\"],\n" +
        "[\"E8F1D4\", \"Chrome White\"],\n" +
        "[\"E8F2EB\", \"Gin\"],\n" +
        "[\"E8F5F2\", \"Aqua Squeeze\"],\n" +
        "[\"E96E00\", \"Clementine\"],\n" +
        "[\"E97451\", \"Burnt Sienna\"],\n" +
        "[\"E97C07\", \"Tahiti Gold\"],\n" +
        "[\"E9CECD\", \"Oyster Pink\"],\n" +
        "[\"E9D75A\", \"Confetti\"],\n" +
        "[\"E9E3E3\", \"Ebb\"],\n" +
        "[\"E9F8ED\", \"Ottoman\"],\n" +
        "[\"E9FFFD\", \"Clear Day\"],\n" +
        "[\"EA88A8\", \"Carissma\"],\n" +
        "[\"EAAE69\", \"Porsche\"],\n" +
        "[\"EAB33B\", \"Tulip Tree\"],\n" +
        "[\"EAC674\", \"Rob Roy\"],\n" +
        "[\"EADAB8\", \"Raffia\"],\n" +
        "[\"EAE8D4\", \"White Rock\"],\n" +
        "[\"EAF6EE\", \"Panache\"],\n" +
        "[\"EAF6FF\", \"Solitude\"],\n" +
        "[\"EAF9F5\", \"Aqua Spring\"],\n" +
        "[\"EAFFFE\", \"Dew\"],\n" +
        "[\"EB9373\", \"Apricot\"],\n" +
        "[\"EBC2AF\", \"Zinnwaldite\"],\n" +
        "[\"ECA927\", \"Fuel Yellow\"],\n" +
        "[\"ECC54E\", \"Ronchi\"],\n" +
        "[\"ECC7EE\", \"French Lilac\"],\n" +
        "[\"ECCDB9\", \"Just Right\"],\n" +
        "[\"ECE090\", \"Wild Rice\"],\n" +
        "[\"ECEBBD\", \"Fall Green\"],\n" +
        "[\"ECEBCE\", \"Aths Special\"],\n" +
        "[\"ECF245\", \"Starship\"],\n" +
        "[\"ED0A3F\", \"Red Ribbon\"],\n" +
        "[\"ED7A1C\", \"Tango\"],\n" +
        "[\"ED9121\", \"Carrot Orange\"],\n" +
        "[\"ED989E\", \"Sea Pink\"],\n" +
        "[\"EDB381\", \"Tacao\"],\n" +
        "[\"EDC9AF\", \"Desert Sand\"],\n" +
        "[\"EDCDAB\", \"Pancho\"],\n" +
        "[\"EDDCB1\", \"Chamois\"],\n" +
        "[\"EDEA99\", \"Primrose\"],\n" +
        "[\"EDF5DD\", \"Frost\"],\n" +
        "[\"EDF5F5\", \"Aqua Haze\"],\n" +
        "[\"EDF6FF\", \"Zumthor\"],\n" +
        "[\"EDF9F1\", \"Narvik\"],\n" +
        "[\"EDFC84\", \"Honeysuckle\"],\n" +
        "[\"EE82EE\", \"Lavender Magenta\"],\n" +
        "[\"EEC1BE\", \"Beauty Bush\"],\n" +
        "[\"EED794\", \"Chalky\"],\n" +
        "[\"EED9C4\", \"Almond\"],\n" +
        "[\"EEDC82\", \"Flax\"],\n" +
        "[\"EEDEDA\", \"Bizarre\"],\n" +
        "[\"EEE3AD\", \"Double Colonial White\"],\n" +
        "[\"EEEEE8\", \"Cararra\"],\n" +
        "[\"EEEF78\", \"Manz\"],\n" +
        "[\"EEF0C8\", \"Tahuna Sands\"],\n" +
        "[\"EEF0F3\", \"Athens Gray\"],\n" +
        "[\"EEF3C3\", \"Tusk\"],\n" +
        "[\"EEF4DE\", \"Loafer\"],\n" +
        "[\"EEF6F7\", \"Catskill White\"],\n" +
        "[\"EEFDFF\", \"Twilight Blue\"],\n" +
        "[\"EEFF9A\", \"Jonquil\"],\n" +
        "[\"EEFFE2\", \"Rice Flower\"],\n" +
        "[\"EF863F\", \"Jaffa\"],\n" +
        "[\"EFEFEF\", \"Gallery\"],\n" +
        "[\"EFF2F3\", \"Porcelain\"],\n" +
        "[\"F091A9\", \"Mauvelous\"],\n" +
        "[\"F0D52D\", \"Golden Dream\"],\n" +
        "[\"F0DB7D\", \"Golden Sand\"],\n" +
        "[\"F0DC82\", \"Buff\"],\n" +
        "[\"F0E2EC\", \"Prim\"],\n" +
        "[\"F0E68C\", \"Khaki\"],\n" +
        "[\"F0EEFD\", \"Selago\"],\n" +
        "[\"F0EEFF\", \"Titan White\"],\n" +
        "[\"F0F8FF\", \"Alice Blue\"],\n" +
        "[\"F0FCEA\", \"Feta\"],\n" +
        "[\"F18200\", \"Gold Drop\"],\n" +
        "[\"F19BAB\", \"Wewak\"],\n" +
        "[\"F1E788\", \"Sahara Sand\"],\n" +
        "[\"F1E9D2\", \"Parchment\"],\n" +
        "[\"F1E9FF\", \"Blue Chalk\"],\n" +
        "[\"F1EEC1\", \"Mint Julep\"],\n" +
        "[\"F1F1F1\", \"Seashell\"],\n" +
        "[\"F1F7F2\", \"Saltpan\"],\n" +
        "[\"F1FFAD\", \"Tidal\"],\n" +
        "[\"F1FFC8\", \"Chiffon\"],\n" +
        "[\"F2552A\", \"Flamingo\"],\n" +
        "[\"F28500\", \"Tangerine\"],\n" +
        "[\"F2C3B2\", \"Mandys Pink\"],\n" +
        "[\"F2F2F2\", \"Concrete\"],\n" +
        "[\"F2FAFA\", \"Black Squeeze\"],\n" +
        "[\"F34723\", \"Pomegranate\"],\n" +
        "[\"F3AD16\", \"Buttercup\"],\n" +
        "[\"F3D69D\", \"New Orleans\"],\n" +
        "[\"F3D9DF\", \"Vanilla Ice\"],\n" +
        "[\"F3E7BB\", \"Sidecar\"],\n" +
        "[\"F3E9E5\", \"Dawn Pink\"],\n" +
        "[\"F3EDCF\", \"Wheatfield\"],\n" +
        "[\"F3FB62\", \"Canary\"],\n" +
        "[\"F3FBD4\", \"Orinoco\"],\n" +
        "[\"F3FFD8\", \"Carla\"],\n" +
        "[\"F400A1\", \"Hollywood Cerise\"],\n" +
        "[\"F4A460\", \"Sandy brown\"],\n" +
        "[\"F4C430\", \"Saffron\"],\n" +
        "[\"F4D81C\", \"Ripe Lemon\"],\n" +
        "[\"F4EBD3\", \"Janna\"],\n" +
        "[\"F4F2EE\", \"Pampas\"],\n" +
        "[\"F4F4F4\", \"Wild Sand\"],\n" +
        "[\"F4F8FF\", \"Zircon\"],\n" +
        "[\"F57584\", \"Froly\"],\n" +
        "[\"F5C85C\", \"Cream Can\"],\n" +
        "[\"F5C999\", \"Manhattan\"],\n" +
        "[\"F5D5A0\", \"Maize\"],\n" +
        "[\"F5DEB3\", \"Wheat\"],\n" +
        "[\"F5E7A2\", \"Sandwisp\"],\n" +
        "[\"F5E7E2\", \"Pot Pourri\"],\n" +
        "[\"F5E9D3\", \"Albescent White\"],\n" +
        "[\"F5EDEF\", \"Soft Peach\"],\n" +
        "[\"F5F3E5\", \"Ecru White\"],\n" +
        "[\"F5F5DC\", \"Beige\"],\n" +
        "[\"F5FB3D\", \"Golden Fizz\"],\n" +
        "[\"F5FFBE\", \"Australian Mint\"],\n" +
        "[\"F64A8A\", \"French Rose\"],\n" +
        "[\"F653A6\", \"Brilliant Rose\"],\n" +
        "[\"F6A4C9\", \"Illusion\"],\n" +
        "[\"F6F0E6\", \"Merino\"],\n" +
        "[\"F6F7F7\", \"Black Haze\"],\n" +
        "[\"F6FFDC\", \"Spring Sun\"],\n" +
        "[\"F7468A\", \"Violet Red\"],\n" +
        "[\"F77703\", \"Chilean Fire\"],\n" +
        "[\"F77FBE\", \"Persian Pink\"],\n" +
        "[\"F7B668\", \"Rajah\"],\n" +
        "[\"F7C8DA\", \"Azalea\"],\n" +
        "[\"F7DBE6\", \"We Peep\"],\n" +
        "[\"F7F2E1\", \"Quarter Spanish White\"],\n" +
        "[\"F7F5FA\", \"Whisper\"],\n" +
        "[\"F7FAF7\", \"Snow Drift\"],\n" +
        "[\"F8B853\", \"Casablanca\"],\n" +
        "[\"F8C3DF\", \"Chantilly\"],\n" +
        "[\"F8D9E9\", \"Cherub\"],\n" +
        "[\"F8DB9D\", \"Marzipan\"],\n" +
        "[\"F8DD5C\", \"Energy Yellow\"],\n" +
        "[\"F8E4BF\", \"Givry\"],\n" +
        "[\"F8F0E8\", \"White Linen\"],\n" +
        "[\"F8F4FF\", \"Magnolia\"],\n" +
        "[\"F8F6F1\", \"Spring Wood\"],\n" +
        "[\"F8F7DC\", \"Coconut Cream\"],\n" +
        "[\"F8F7FC\", \"White Lilac\"],\n" +
        "[\"F8F8F7\", \"Desert Storm\"],\n" +
        "[\"F8F99C\", \"Texas\"],\n" +
        "[\"F8FACD\", \"Corn Field\"],\n" +
        "[\"F8FDD3\", \"Mimosa\"],\n" +
        "[\"F95A61\", \"Carnation\"],\n" +
        "[\"F9BF58\", \"Saffron Mango\"],\n" +
        "[\"F9E0ED\", \"Carousel Pink\"],\n" +
        "[\"F9E4BC\", \"Dairy Cream\"],\n" +
        "[\"F9E663\", \"Portica\"],\n" +
        "[\"F9EAF3\", \"Amour\"],\n" +
        "[\"F9F8E4\", \"Rum Swizzle\"],\n" +
        "[\"F9FF8B\", \"Dolly\"],\n" +
        "[\"F9FFF6\", \"Sugar Cane\"],\n" +
        "[\"FA7814\", \"Ecstasy\"],\n" +
        "[\"FA9D5A\", \"Tan Hide\"],\n" +
        "[\"FAD3A2\", \"Corvette\"],\n" +
        "[\"FADFAD\", \"Peach Yellow\"],\n" +
        "[\"FAE600\", \"Turbo\"],\n" +
        "[\"FAEAB9\", \"Astra\"],\n" +
        "[\"FAECCC\", \"Champagne\"],\n" +
        "[\"FAF0E6\", \"Linen\"],\n" +
        "[\"FAF3F0\", \"Fantasy\"],\n" +
        "[\"FAF7D6\", \"Citrine White\"],\n" +
        "[\"FAFAFA\", \"Alabaster\"],\n" +
        "[\"FAFDE4\", \"Hint of Yellow\"],\n" +
        "[\"FAFFA4\", \"Milan\"],\n" +
        "[\"FB607F\", \"Brink Pink\"],\n" +
        "[\"FB8989\", \"Geraldine\"],\n" +
        "[\"FBA0E3\", \"Lavender Rose\"],\n" +
        "[\"FBA129\", \"Sea Buckthorn\"],\n" +
        "[\"FBAC13\", \"Sun\"],\n" +
        "[\"FBAED2\", \"Lavender Pink\"],\n" +
        "[\"FBB2A3\", \"Rose Bud\"],\n" +
        "[\"FBBEDA\", \"Cupid\"],\n" +
        "[\"FBCCE7\", \"Classic Rose\"],\n" +
        "[\"FBCEB1\", \"Apricot Peach\"],\n" +
        "[\"FBE7B2\", \"Banana Mania\"],\n" +
        "[\"FBE870\", \"Marigold Yellow\"],\n" +
        "[\"FBE96C\", \"Festival\"],\n" +
        "[\"FBEA8C\", \"Sweet Corn\"],\n" +
        "[\"FBEC5D\", \"Candy Corn\"],\n" +
        "[\"FBF9F9\", \"Hint of Red\"],\n" +
        "[\"FBFFBA\", \"Shalimar\"],\n" +
        "[\"FC0FC0\", \"Shocking Pink\"],\n" +
        "[\"FC80A5\", \"Tickle Me Pink\"],\n" +
        "[\"FC9C1D\", \"Tree Poppy\"],\n" +
        "[\"FCC01E\", \"Lightning Yellow\"],\n" +
        "[\"FCD667\", \"Goldenrod\"],\n" +
        "[\"FCD917\", \"Candlelight\"],\n" +
        "[\"FCDA98\", \"Cherokee\"],\n" +
        "[\"FCF4D0\", \"Double Pearl Lusta\"],\n" +
        "[\"FCF4DC\", \"Pearl Lusta\"],\n" +
        "[\"FCF8F7\", \"Vista White\"],\n" +
        "[\"FCFBF3\", \"Bianca\"],\n" +
        "[\"FCFEDA\", \"Moon Glow\"],\n" +
        "[\"FCFFE7\", \"China Ivory\"],\n" +
        "[\"FCFFF9\", \"Ceramic\"],\n" +
        "[\"FD0E35\", \"Torch Red\"],\n" +
        "[\"FD5B78\", \"Wild Watermelon\"],\n" +
        "[\"FD7B33\", \"Crusta\"],\n" +
        "[\"FD7C07\", \"Sorbus\"],\n" +
        "[\"FD9FA2\", \"Sweet Pink\"],\n" +
        "[\"FDD5B1\", \"Light Apricot\"],\n" +
        "[\"FDD7E4\", \"Pig Pink\"],\n" +
        "[\"FDE1DC\", \"Cinderella\"],\n" +
        "[\"FDE295\", \"Golden Glow\"],\n" +
        "[\"FDE910\", \"Lemon\"],\n" +
        "[\"FDF5E6\", \"Old Lace\"],\n" +
        "[\"FDF6D3\", \"Half Colonial White\"],\n" +
        "[\"FDF7AD\", \"Drover\"],\n" +
        "[\"FDFEB8\", \"Pale Prim\"],\n" +
        "[\"FDFFD5\", \"Cumulus\"],\n" +
        "[\"FE28A2\", \"Persian Rose\"],\n" +
        "[\"FE4C40\", \"Sunset Orange\"],\n" +
        "[\"FE6F5E\", \"Bittersweet\"],\n" +
        "[\"FE9D04\", \"California\"],\n" +
        "[\"FEA904\", \"Yellow Sea\"],\n" +
        "[\"FEBAAD\", \"Melon\"],\n" +
        "[\"FED33C\", \"Bright Sun\"],\n" +
        "[\"FED85D\", \"Dandelion\"],\n" +
        "[\"FEDB8D\", \"Salomie\"],\n" +
        "[\"FEE5AC\", \"Cape Honey\"],\n" +
        "[\"FEEBF3\", \"Remy\"],\n" +
        "[\"FEEFCE\", \"Oasis\"],\n" +
        "[\"FEF0EC\", \"Bridesmaid\"],\n" +
        "[\"FEF2C7\", \"Beeswax\"],\n" +
        "[\"FEF3D8\", \"Bleach White\"],\n" +
        "[\"FEF4CC\", \"Pipi\"],\n" +
        "[\"FEF4DB\", \"Half Spanish White\"],\n" +
        "[\"FEF4F8\", \"Wisp Pink\"],\n" +
        "[\"FEF5F1\", \"Provincial Pink\"],\n" +
        "[\"FEF7DE\", \"Half Dutch White\"],\n" +
        "[\"FEF8E2\", \"Solitaire\"],\n" +
        "[\"FEF8FF\", \"White Pointer\"],\n" +
        "[\"FEF9E3\", \"Off Yellow\"],\n" +
        "[\"FEFCED\", \"Orange White\"],\n" +
        "[\"FF0000\", \"Red\"],\n" +
        "[\"FF007F\", \"Rose\"],\n" +
        "[\"FF00CC\", \"Purple Pizzazz\"],\n" +
        "[\"FF00FF\", \"Magenta / Fuchsia\"],\n" +
        "[\"FF2400\", \"Scarlet\"],\n" +
        "[\"FF3399\", \"Wild Strawberry\"],\n" +
        "[\"FF33CC\", \"Razzle Dazzle Rose\"],\n" +
        "[\"FF355E\", \"Radical Red\"],\n" +
        "[\"FF3F34\", \"Red Orange\"],\n" +
        "[\"FF4040\", \"Coral Red\"],\n" +
        "[\"FF4D00\", \"Vermilion\"],\n" +
        "[\"FF4F00\", \"International Orange\"],\n" +
        "[\"FF6037\", \"Outrageous Orange\"],\n" +
        "[\"FF6600\", \"Blaze Orange\"],\n" +
        "[\"FF66FF\", \"Pink Flamingo\"],\n" +
        "[\"FF681F\", \"Orange\"],\n" +
        "[\"FF69B4\", \"Hot Pink\"],\n" +
        "[\"FF6B53\", \"Persimmon\"],\n" +
        "[\"FF6FFF\", \"Blush Pink\"],\n" +
        "[\"FF7034\", \"Burning Orange\"],\n" +
        "[\"FF7518\", \"Pumpkin\"],\n" +
        "[\"FF7D07\", \"Flamenco\"],\n" +
        "[\"FF7F00\", \"Flush Orange\"],\n" +
        "[\"FF7F50\", \"Coral\"],\n" +
        "[\"FF8C69\", \"Salmon\"],\n" +
        "[\"FF9000\", \"Pizazz\"],\n" +
        "[\"FF910F\", \"West Side\"],\n" +
        "[\"FF91A4\", \"Pink Salmon\"],\n" +
        "[\"FF9933\", \"Neon Carrot\"],\n" +
        "[\"FF9966\", \"Atomic Tangerine\"],\n" +
        "[\"FF9980\", \"Vivid Tangerine\"],\n" +
        "[\"FF9E2C\", \"Sunshade\"],\n" +
        "[\"FFA000\", \"Orange Peel\"],\n" +
        "[\"FFA194\", \"Mona Lisa\"],\n" +
        "[\"FFA500\", \"Web Orange\"],\n" +
        "[\"FFA6C9\", \"Carnation Pink\"],\n" +
        "[\"FFAB81\", \"Hit Pink\"],\n" +
        "[\"FFAE42\", \"Yellow Orange\"],\n" +
        "[\"FFB0AC\", \"Cornflower Lilac\"],\n" +
        "[\"FFB1B3\", \"Sundown\"],\n" +
        "[\"FFB31F\", \"My Sin\"],\n" +
        "[\"FFB555\", \"Texas Rose\"],\n" +
        "[\"FFB7D5\", \"Cotton Candy\"],\n" +
        "[\"FFB97B\", \"Macaroni and Cheese\"],\n" +
        "[\"FFBA00\", \"Selective Yellow\"],\n" +
        "[\"FFBD5F\", \"Koromiko\"],\n" +
        "[\"FFBF00\", \"Amber\"],\n" +
        "[\"FFC0A8\", \"Wax Flower\"],\n" +
        "[\"FFC0CB\", \"Pink\"],\n" +
        "[\"FFC3C0\", \"Your Pink\"],\n" +
        "[\"FFC901\", \"Supernova\"],\n" +
        "[\"FFCBA4\", \"Flesh\"],\n" +
        "[\"FFCC33\", \"Sunglow\"],\n" +
        "[\"FFCC5C\", \"Golden Tainoi\"],\n" +
        "[\"FFCC99\", \"Peach Orange\"],\n" +
        "[\"FFCD8C\", \"Chardonnay\"],\n" +
        "[\"FFD1DC\", \"Pastel Pink\"],\n" +
        "[\"FFD2B7\", \"Romantic\"],\n" +
        "[\"FFD38C\", \"Grandis\"],\n" +
        "[\"FFD700\", \"Gold\"],\n" +
        "[\"FFD800\", \"School bus Yellow\"],\n" +
        "[\"FFD8D9\", \"Cosmos\"],\n" +
        "[\"FFDB58\", \"Mustard\"],\n" +
        "[\"FFDCD6\", \"Peach Schnapps\"],\n" +
        "[\"FFDDAF\", \"Caramel\"],\n" +
        "[\"FFDDCD\", \"Tuft Bush\"],\n" +
        "[\"FFDDCF\", \"Watusi\"],\n" +
        "[\"FFDDF4\", \"Pink Lace\"],\n" +
        "[\"FFDEAD\", \"Navajo White\"],\n" +
        "[\"FFDEB3\", \"Frangipani\"],\n" +
        "[\"FFE1DF\", \"Pippin\"],\n" +
        "[\"FFE1F2\", \"Pale Rose\"],\n" +
        "[\"FFE2C5\", \"Negroni\"],\n" +
        "[\"FFE5A0\", \"Cream Brulee\"],\n" +
        "[\"FFE5B4\", \"Peach\"],\n" +
        "[\"FFE6C7\", \"Tequila\"],\n" +
        "[\"FFE772\", \"Kournikova\"],\n" +
        "[\"FFEAC8\", \"Sandy Beach\"],\n" +
        "[\"FFEAD4\", \"Karry\"],\n" +
        "[\"FFEC13\", \"Broom\"],\n" +
        "[\"FFEDBC\", \"Colonial White\"],\n" +
        "[\"FFEED8\", \"Derby\"],\n" +
        "[\"FFEFA1\", \"Vis Vis\"],\n" +
        "[\"FFEFC1\", \"Egg White\"],\n" +
        "[\"FFEFD5\", \"Papaya Whip\"],\n" +
        "[\"FFEFEC\", \"Fair Pink\"],\n" +
        "[\"FFF0DB\", \"Peach Cream\"],\n" +
        "[\"FFF0F5\", \"Lavender blush\"],\n" +
        "[\"FFF14F\", \"Gorse\"],\n" +
        "[\"FFF1B5\", \"Buttermilk\"],\n" +
        "[\"FFF1D8\", \"Pink Lady\"],\n" +
        "[\"FFF1EE\", \"Forget Me Not\"],\n" +
        "[\"FFF1F9\", \"Tutu\"],\n" +
        "[\"FFF39D\", \"Picasso\"],\n" +
        "[\"FFF3F1\", \"Chardon\"],\n" +
        "[\"FFF46E\", \"Paris Daisy\"],\n" +
        "[\"FFF4CE\", \"Barley White\"],\n" +
        "[\"FFF4DD\", \"Egg Sour\"],\n" +
        "[\"FFF4E0\", \"Sazerac\"],\n" +
        "[\"FFF4E8\", \"Serenade\"],\n" +
        "[\"FFF4F3\", \"Chablis\"],\n" +
        "[\"FFF5EE\", \"Seashell Peach\"],\n" +
        "[\"FFF5F3\", \"Sauvignon\"],\n" +
        "[\"FFF6D4\", \"Milk Punch\"],\n" +
        "[\"FFF6DF\", \"Varden\"],\n" +
        "[\"FFF6F5\", \"Rose White\"],\n" +
        "[\"FFF8D1\", \"Baja White\"],\n" +
        "[\"FFF9E2\", \"Gin Fizz\"],\n" +
        "[\"FFF9E6\", \"Early Dawn\"],\n" +
        "[\"FFFACD\", \"Lemon Chiffon\"],\n" +
        "[\"FFFAF4\", \"Bridal Heath\"],\n" +
        "[\"FFFBDC\", \"Scotch Mist\"],\n" +
        "[\"FFFBF9\", \"Soapstone\"],\n" +
        "[\"FFFC99\", \"Witch Haze\"],\n" +
        "[\"FFFCEA\", \"Buttery White\"],\n" +
        "[\"FFFCEE\", \"Island Spice\"],\n" +
        "[\"FFFDD0\", \"Cream\"],\n" +
        "[\"FFFDE6\", \"Chilean Heath\"],\n" +
        "[\"FFFDE8\", \"Travertine\"],\n" +
        "[\"FFFDF3\", \"Orchid White\"],\n" +
        "[\"FFFDF4\", \"Quarter Pearl Lusta\"],\n" +
        "[\"FFFEE1\", \"Half and Half\"],\n" +
        "[\"FFFEEC\", \"Apricot White\"],\n" +
        "[\"FFFEF0\", \"Rice Cake\"],\n" +
        "[\"FFFEF6\", \"Black White\"],\n" +
        "[\"FFFEFD\", \"Romance\"],\n" +
        "[\"FFFF00\", \"Yellow\"],\n" +
        "[\"FFFF66\", \"Laser Lemon\"],\n" +
        "[\"FFFF99\", \"Pale Canary\"],\n" +
        "[\"FFFFB4\", \"Portafino\"],\n" +
        "[\"FFFFF0\", \"Ivory\"],\n" +
        "[\"FFFFFF\", \"White\"]\n" +
        "]\n" +
        "\n" +
        "};\n" +
        "jdi.ntc.init()";
}
