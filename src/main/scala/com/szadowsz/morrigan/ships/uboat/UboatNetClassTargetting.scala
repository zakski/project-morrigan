package com.szadowsz.morrigan.ships.uboat

import com.szadowsz.common.net.Uri
import com.szadowsz.maeve.core.instruction.extractor.JsoupExtractor
import com.szadowsz.morrigan.JsoupPathTargetting
import com.szadowsz.morrigan.ships.uboat.filter.UboatNetClassFilter


/**
  * Created on 21/06/2016.
  */
object UboatNetClassTargetting extends JsoupPathTargetting {



  override val baseUrl = Uri("http://uboat.net/allies/warships/")

  override val urlPaths: Seq[String] = List(
    "class/1.html", // Tribal class
    "class/2.html", // Black Swan class
    "class/3.html", // Banff class
    "class/4.html", // Castle class
    "class/5.html", // River class
    "class/6.html", // Loch class
    "class/7.html", // Bay class
    "class/8.html", // Colony class
    "class/9.html", // A class
    "class/10.html", // B class
    "class/11.html", // C class
    "class/12.html", // D class
    "class/13.html", // E class
    "class/14.html", // F class
    "class/15.html", // G Class
    "class/16.html", // H class
    "class/17.html", // I class
    "class/18.html", // J class
    "class/19.html", // Havant class
    "class/20.html", // Admiralty S class
    // TODO check "class/21.html",
    "class/22.html", // Hunt (Type I) class
    "class/23.html", // Admiralty V & W class
    "class/24.html", // Town class
    "class/25.html", // K class
    "class/26.html", // O class
    "class/27.html", // P class
    "class/28.html", // Q class
    "class/29.html", // N class
    "class/30.html", // L class
    "class/31.html", // M class
    "class/32.html", // R class
    "class/33.html", // S class
    "class/34.html", // W class
    "class/35.html", // T class
    "class/36.html", // U class
    "class/37.html", // V class
    "class/38.html", // Z class
    "class/39.html", // Ca class
    "class/40.html", // Battle class
    "class/41.html", // Flower (rev.) class
    "class/42.html", // Flower class
    "class/43.html", // O class
    // TODO check "class/44.html",
    "class/45.html", // H class
    "class/46.html", // P class
    "class/47.html", // R class
    "class/48.html", // River class
    "class/49.html", // Porpoise class
    "class/50.html", // U class
    "class/51.html", // V class
    "class/52.html", // S class
    "class/53.html", // T class
    "class/54.html", // Queen Elizabeth class
    "class/55.html", // Royal Sovereign class
    "class/56.html", // Nelson class
    "class/57.html", // King George V class
    // TODO check "class/58.html",
    // TODO check "class/59.html",
    "class/60.html", // Kent class
    "class/61.html", // York class
    "class/62.html", // Caledon class
    "class/63.html", // D class
    "class/64.html", // Cavendish class
    // TODO check "class/65.html",
    "class/66.html", // E class
    "class/67.html", // Leander class
    "class/68.html", // Perth class
    "class/69.html", // Arethusa class
    "class/70.html", // Southampton class
    "class/71.html", // Belfast class
    "class/72.html", // Dido class
    "class/73.html", // Fiji class
    "class/74.html", // Bellona class
    // TODO check "class/75.html",
    "class/76.html", // Adventure class
    "class/77.html", // Abdiel class
    "class/78.html", // Evarts class
    "class/79.html", // Buckley class
    "class/80.html", // Cannon class
    "class/81.html", // Edsall class
    "class/82.html", // Rudderow class
    "class/83.html", // John C. Butler class
    "class/84.html", // Benham class
    "class/85.html", // Sims class
    "class/86.html", // Bristol class
    "class/87.html", // Benson / Gleaves class
    "class/88.html", // Mahan class
    "class/89.html", // Somers class
    "class/90.html", // Farragut class
    "class/91.html", // Gridley class
    // TODO check "class/92.html",
    "class/93.html", // Fletcher class
    "class/94.html", // Allen M. Sumner class
    "class/95.html", // Wickes class
    "class/96.html", // Clemson class
    "class/97.html", // Furious class
    "class/98.html", // Courageous class
    "class/99.html", // Ark Royal class
    "class/100.html", // Illustrious class
    // TODO check "class/101.html",
    // TODO check "class/102.html",
    "class/103.html", // Eagle class
    "class/104.html", // Argus class
    "class/105.html", // Essex class
    "class/106.html", // Midway class
    // TODO check "class/107.html",
    "class/108.html", // Commencement Bay class
    "class/109.html", // Sangamon class
    "class/110.html", // Casablanca class
    "class/111.html", // Long Island / Archer class
    "class/112.html", // Avenger / Charger class
    "class/113.html", // Bogue class
    "class/114.html", // Ameer class
    "class/115.html", // Independence class
    "class/116.html", // Omaha class
    // TODO check "class/107.html",
    "class/118.html", // Northampton class
    "class/119.html", // New Orleans class
    "class/120.html", // Portland class
    "class/121.html", // Brooklyn class
    // TODO check "class/122.html",
    "class/123.html", // Atlanta class
    "class/124.html", // Cleveland class
    "class/125.html", // Baltimore class
    "class/126.html", // Oakland class
    "class/127.html", // Lexington class
    "class/128.html", // Alaska class
    "class/129.html", // North Carolina class
    "class/130.html", // South Dakota class
    "class/131.html", // Iowa class
    "class/132.html", // Bangor class
    "class/133.html", // Prince class
    // TODO check "class/134.html",
    // TODO check "class/135.html",
    "class/136.html", // Round Table class
    // TODO check "class/137.html",
    "class/138.html", // Llewellyn class
    "class/139.html", // MMS I class
    "class/140.html", // Algerine class
    "class/141.html", // Bathurst class
    "class/142.html", // Grimsby class
    // TODO check "class/143.html",
    "class/144.html", // Birmingham class
    "class/145.html", // No specific class [Armed Merchant Cruiser]
    "class/146.html", // Gato class
    "class/147.html", // Balao class
    "class/148.html", // Mackerel class
    "class/149.html", // Tambor class
    "class/150.html", // Sargo class
    "class/151.html", // Salmon class
    "class/152.html", // Perch class
    "class/153.html", // Narwhal class
    "class/154.html", // Dolphin class
    "class/155.html", // Cachalot class
    "class/156.html", // Barracuda class
    "class/157.html", // Porpoise class
    "class/158.html", // 24 class
    "class/159.html", // Admiral class
    "class/160.html", // Admiralen class
    "class/161.html", // Audacity class
    "class/162.html", // Bittern class
    "class/163.html", // Bridgewater class
    "class/164.html", // Colossus class
    "class/165.html", // De Ruyter class
    "class/166.html", // Douwe Aukes class
    "class/167.html", // Egret class
    "class/168.html", // Flores class
    "class/169.html", // Folkestone class
    "class/170.html", // Gerard Callenburgh class
    "class/171.html", // Gruno class
    "class/172.html", // Halcyon class
    "class/173.html", // Hermes class
    "class/174.html", // Hydra class
    "class/175.html", // Jan van Amstel class
    "class/176.html", // Jan van Brakel class
    "class/177.html", // Java class
    "class/178.html", // Z 5 class
    "class/179.html", // K V class
    "class/180.html", // K VIII class
    "class/181.html", // K XI class
    "class/182.html", // K XIV class
    "class/183.html", // Krakatau class
    "class/184.html", // La Melpoméne class
    "class/185.html", // Merchantile Conversion class
    "class/186.html", // Minotaur class
    "class/187.html", // Nautilus class
    "class/188.html", // O 12 class
    "class/189.html", // O 16 class
    "class/190.html", // O 19 class
    "class/191.html", // O 21 class
    "class/192.html", // O 9 class
    "class/193.html", // Prins van Oranje class
    "class/194.html", // Pro Patria class
    "class/195.html", // Prototype class [Destroyer]
    "class/196.html", // Renown class
    "class/197.html", // Admiralty Leader class
    "class/198.html", // Shakespeare class
    "class/199.html", // Tromp class
    "class/200.html", // Unicorn class
    "class/201.html", // Van Kinsbergen class
    "class/202.html", // Willem van der Zaan class
    "class/203.html", // Ferraris class
    "class/204.html", // A class
    "class/205.html", // A class
    "class/206.html", // S-1 class
    "class/207.html", // S-42 class
    "class/208.html", // R-1 class
    "class/209.html", // Argonaut class
    "class/210.html", // D (Dekabrist) class
    "class/211.html", // L (Leninec) class
    "class/212.html", // M (Malyutka) class
    "class/213.html", // ShCh (Scuka) class
    "class/214.html", // P (Pravda) class
    "class/215.html", // S (Stalinec) class
    "class/216.html", // K (Katjusa) class
    "class/217.html", // Colorado class
    "class/218.html", // Tennessee class
    "class/219.html", // Nevada class
    "class/220.html", // Pennsylvania class
    "class/221.html", // New Mexico class
    "class/222.html", // New York class
    "class/223.html", // Florida class
    "class/224.html", // Porter class
    "class/225.html", // Lapwing class
    "class/226.html", // Auk class
    "class/227.html", // Admirable class
    "class/228.html", // Orzel class
    "class/229.html", // Wicher class
    "class/230.html", // Grom class
    "class/231.html", // Wilk class
    "class/232.html", // Erebus class
    "class/233.html", // Roberts class
    "class/234.html", // Captain class
    "class/235.html", // M class
    "class/236.html", // Yorktown class
    "class/237.html", // Ranger class
    "class/238.html", // No specific class [Armed Yacht]
    "class/239.html", // Fundy class
    "class/240.html", // Cornwallis class
    "class/241.html", // Sevastopol class
    "class/242.html", // Wasp class
    "class/243.html", // Gryf class
    "class/244.html", // London class
    "class/245.html", // Dorsetshire class
    "class/246.html", // Wichita class
    "class/247.html", // Gearing class
    "class/248.html", // A (AG) class
    "class/249.html", // Project 7 class
    "class/250.html", // Project 7u class
    "class/251.html", // Project 30 class
    "class/252.html", // Novik class
    "class/253.html", // Regele Ferdinand class
    "class/254.html", // Marashti class
    // TODO check "class/255.html",
    // TODO check "class/256.html",
    "class/257.html", // Tench class
    "class/258.html", // Wyoming class
    "class/259.html", // Raven class
    "class/260.html", // Sampson class
    "class/261.html", // Caldwell class
    "class/262.html", // Bagley class
    "class/263.html", // Pensacola class
    "class/264.html", // O-1 class
    "class/265.html", // S-3 class
    "class/266.html", // S-4 class
    "class/267.html", // S-48 class
    "class/268.html", // Shark class
    "class/269.html", // St. Louis class
    "class/270.html", // Tacoma class
    "class/271.html", // Courbet class
    "class/272.html", // Bretagne class
    "class/273.html", // Richelieu class
    "class/274.html", // Dunkerque class
    "class/275.html", // Béarn class
    "class/276.html", // Duquesne class
    "class/277.html", // Suffren class
    "class/278.html", // Algérie class
    "class/279.html", // Duguay-Trouin class
    "class/280.html", // Jeanne d'Arc class
    "class/281.html", // Pluton class
    "class/282.html", // Emile Bertin class
    "class/283.html", // La Galissonniere class
    "class/284.html", // Chacal class
    "class/285.html", // Bourrasque class
    "class/286.html", // L'Adroit class
    "class/287.html", // Guepard class
    "class/288.html", // Aigle class
    "class/289.html", // Vauquelin class
    "class/290.html", // Le Fantasque class
    "class/291.html", // Mogador class
    "class/292.html", // Le Hardi class
    "class/293.html", // Requin class
    "class/294.html", // Surcouf class
    "class/295.html", // Circé class
    "class/296.html", // Redoutable class
    "class/297.html", // Saphir class
    "class/298.html", // Argonaute class
    "class/299.html", // Diane class
    "class/300.html", // Orion class
    "class/301.html", // L'Espoire class
    "class/302.html", // Agosta class
    "class/303.html", // Minerve class
    "class/304.html", // Ville d'Ys class
    "class/305.html", // Bougainville class
    "class/306.html", // Somme class
    "class/307.html", // Ailette class
    "class/308.html", // Suippe class
    "class/309.html", // Dubourdieu class
    "class/310.html", // Arras class
    "class/311.html", // Altair class
    "class/312.html", // Granit class
    "class/313.html", // Ardent class
    "class/314.html", // Friponne class
    "class/315.html", // Luronne class
    "class/316.html", // Valliante class
    "class/317.html", // Chamois class
    "class/318.html", // Elan class
    "class/319.html", // Albatre class
    "class/320.html", // Kingfisher class
    "class/321.html", // Kil class
    "class/322.html", // Shoreham class
    "class/323.html", // Falmouth class
    "class/324.html", // Modified Black Swan class
    "class/325.html", // Net class
    "class/326.html", // Bar class
    "class/327.html", // Dog class
    "class/328.html", // Dance class
    "class/329.html", // Fish class
    "class/330.html", // Hill class
    "class/331.html", // Military class
    "class/332.html", // No specific class [ASW Trawler]
    "class/333.html", // Hunt class
    "class/334.html", // Axe class
    "class/335.html", // Mersey class
    "class/336.html", // Lake class
    "class/337.html", // Tree class
    "class/338.html", // Shakespearian class
    "class/339.html", // Isles class
    "class/340.html", // P class
    "class/341.html", // No specific class [MS Trawler]
    "class/342.html", // No specific class [Submarine Depot Ship]
    "class/343.html", // Maidstone class
    "class/344.html", // No specific class [Destroyer Depot Ship]
    "class/345.html", // Hecla class
    "class/346.html", // No specific class [Repair Ship]
    "class/347.html", // Assistance class
    "class/348.html", // Moray Firth class
    "class/349.html", // Beachy Head class
    "class/350.html", // G 13 class
    "class/351.html", // Rollicker class
    "class/352.html", // Saint class
    "class/353.html", // Brigand class
    "class/354.html", // Nimble class
    "class/355.html", // Assurance class
    "class/356.html", // Bustler class
    "class/357.html", // Envoy class
    "class/358.html", // Favourite class
    "class/359.html", // Director class
    "class/360.html", // No specific class [Rescue Tug]
    "class/361.html", // Dromedary class
    "class/362.html", // Robust class
    "class/363.html", // No specific class [Tug]
    "class/364.html", // Alliance class
    "class/365.html", // West class
    "class/366.html", // Poultry class
    "class/367.html", // Burn class
    "class/368.html", // Impetus class
    "class/369.html", // Alligator class
    "class/370.html", // Busy class
    "class/371.html", // Dunnet class
    "class/372.html", // Bar class
    "class/373.html", // Net class
    "class/374.html", // Pre class
    "class/375.html", // King Salvor class
    "class/376.html", // Dispenser class
    "class/377.html", // Parkgate class
    "class/378.html", // Moorgate class
    "class/379.html", // Nairana class
    "class/380.html", // L class
    "class/381.html", // Activity class
    "class/382.html", // Pretoria Castle class
    "class/383.html", // Campania class
    "class/384.html", // Type VIIC class
    "class/385.html", // Perla class
    "class/386.html", // Platino class
    "class/387.html", // P 611 class
    "class/388.html", // Trinculo class
    "class/389.html", // No specific class [Mooring Vessel]
    "class/390.html", // Moor class
    "class/391.html", // Moorburn class
    "class/392.html", // Admiralty R class
    "class/393.html", // Admiralty Modified W class
    "class/394.html", // Johan Maurits van Nassau class
    "class/395.html", // Z 1 class
    "class/396.html", // Bangkalan class
    "class/397.html", // Soemenep class
    "class/398.html", // Rigel class
    "class/399.html", // O 8 class
    "class/400.html", // O 7 class
    "class/401.html", // Hunt (Type II) class
    "class/402.html", // Hunt (Type III) class
    "class/403.html", // Hunt (Type IV) class
    "class/404.html", // No specific class [Submarine Depot Ship]
    "class/405.html", // Gloucester class
    "class/406.html", // Ceres class
    "class/407.html", // Carlisle class
    "class/408.html", // Repeat Bogue class
    "class/409.html", // Attacker class
    "class/410.html", // Indomitable class
    "class/411.html", // Implacable class
    "class/412.html", // Basset class
    "class/413.html", // No specific class [Destroyer tender]
    "class/414.html", // Dobbin class
    "class/415.html", // Altair class
    "class/416.html", // No specific class [Repair ship]
    "class/417.html", // Dixie class
    "class/418.html", // Hamul class
    "class/419.html", // Klondike class
    "class/420.html", // Shenandoah class
    "class/421.html", // Vulcan class
    "class/422.html", // Delta class
    "class/423.html", // Amphion class
    "class/424.html", // Laertes class
    "class/425.html", // No specific class [Submarine tender]
    "class/426.html", // Fulton class
    "class/427.html", // Griffin class
    "class/428.html", // Aegir class
    "class/429.html", // Kanawha class
    "class/430.html", // Patoka class
    "class/431.html", // Kaweah class
    "class/432.html", // Cimarron class
    "class/433.html", // Chicopee class
    "class/434.html", // Kennebec class
    "class/435.html", // Mattaponi class
    "class/436.html", // No specific class [Oiler]
    "class/437.html", // Suamico class
    "class/438.html", // Ashtabula class
    "class/439.html", // Chiwawa class
    "class/440.html", // Escambia class
    "class/441.html", // No specific class [Seaplane tender]
    "class/442.html", // Curtiss class
    "class/443.html", // Currituck class
    "class/444.html", // Tangier class
    "class/445.html", // Kenneth Whiting class
    "class/446.html", // Barnegat class
    "class/447.html", // Diver class
    "class/448.html", // Anchor class
    "class/449.html", // Bolster class
    "class/450.html", // Chanticleer class
    "class/451.html", // Penguin class
    "class/452.html", // Sonoma class
    "class/453.html", // No specific class [Fleet tug]
    "class/454.html", // Bagaduce class
    "class/455.html", // Navajo class
    "class/456.html", // Abnaki class
    "class/457.html", // No specific class [Net tender]
    "class/458.html", // Aloe class
    "class/459.html", // Ailanthus class
    "class/460.html", // Cohoes class
    "class/461.html", // Patrol Craft Escort class
    "class/462.html", // Eagle class
    "class/463.html", // PC-461 class
    "class/464.html", // SC-497 class
    "class/465.html", // Dubuque class
    "class/466.html", // Sacramento class
    "class/467.html", // Asheville class
    "class/468.html", // Erie class
    "class/469.html", // Adroit class
    "class/470.html", // PCS-1376 class
    "class/471.html", // Wake class
    "class/472.html", // Panay class
    "class/473.html", // Luzon class
    "class/474.html", // Prototypes class [Submarine chaser]
    "class/475.html", // Prototypes class [Patrol craft]
    "class/476.html", // Accentor class
    "class/477.html", // YMS class
    "class/478.html", // Georgios Averoff class
    "class/479.html", // Helli class
    "class/480.html", // Kilkis class
    "class/481.html", // Katsonis class
    "class/482.html", // Proteus class
    "class/483.html", // Aetos class
    "class/484.html", // Kondouriotis class
    "class/485.html", // Vasilefs Georgios class
    "class/486.html", // Niki class
    "class/487.html", // Thyella class
    "class/488.html", // Alcyon class
    "class/489.html", // Kidonia class
    "class/490.html", // Aixos class
    "class/491.html", // No specific class [Minelayer]
    "class/492.html", // Bogatyr class
    "class/493.html", // Kirov (Project 26) class
    "class/494.html", // Maxim Gorkiy (Project 26-bis) class
    "class/495.html", // Kraznyi Kavkaz class
    "class/496.html", // Krasnyi Krym class
    "class/497.html", // Chervona Ukraina class
    "class/498.html", // Tashkent (Project 20) class
    "class/499.html", // Leningrad (Project 1) class
    "class/500.html", // Minsk (Project 38) class
    "class/501.html", // Sirene class
    "class/502.html", // Ariane class
    // TODO check "class/503.html",
    "class/504.html", // No specific class [Minesweeper]
    "class/505.html", // Gar class
    "class/506.html", // PC class
    "class/507.html", // Mazur class
    "class/508.html", // Jaskolka class
    "class/509.html", // General Haller class
    "class/510.html", // Charles Lawrence class
    "class/511.html", // Crosley class
    "class/512.html", // Minas Gerais class
    "class/513.html", // Bahia class
    "class/514.html", // Para class
    "class/515.html", // K class
    "class/516.html", // Marcilio Dias class
    "class/517.html", // Henrique Dias class
    "class/518.html", // Humaita class
    "class/519.html", // Tupy class
    "class/520.html", // Carioca class
    "class/521.html", // ELCO 77' class
    "class/522.html", // ELCO 80' class
    "class/523.html", // Higgins 78' class
    "class/524.html", // Oriani class
    "class/525.html", // Huckins 78' class
    "class/526.html", // Vosper 72' class
    "class/527.html", // Folgal 58' class
    "class/528.html", // Fisher 58' class
    "class/529.html", // PT 5 class
    "class/530.html", // PT 6 class
    "class/531.html", // PT 7 class
    "class/532.html", // PT 8 class
    "class/533.html", // PT 9 class
    "class/534.html", // ELCO 70' class
    "class/535.html", // Conte di Cavour class
    "class/536.html", // Caio Duilio class
    "class/537.html", // Littorio class
    "class/538.html", // Luigi Cadorna class
    "class/539.html", // Raimondo Montecuccoli class
    "class/540.html", // Emanuele Filiberto Duca d'Aosta class
    "class/541.html", // Giuseppe Garibaldi class
    "class/542.html", // Attilio Regolo class
    "class/543.html", // Goffredo Mameli class
    "class/544.html", // Fratelli Bandiera class
    "class/545.html", // Squalo class
    "class/546.html", // Luigi Settembrini class
    "class/547.html", // Glauco class
    "class/548.html", // Brin class
    "class/549.html", // Marcello class
    "class/550.html", // Ammiraglio Cagni class
    "class/551.html", // Flutto class
    "class/552.html", // Argonauta class
    "class/553.html", // Sirena class
    "class/554.html", // Adua class
    // TODO check "class/555.html",
    "class/556.html", // Acciaio class
    "class/557.html", // Marcantonio Bragadin class
    "class/558.html", // Foca class
    "class/559.html", // Turbine class
    "class/560.html", // Navigatori class
    "class/561.html", // Maestrale class
    "class/562.html", // Soldati (1st series) class
    "class/563.html", // Soldati (2nd series) class
    "class/564.html", // Giuseppe Cesare Abba class
    "class/565.html", // Giuseppe Sirtori class
    "class/566.html", // Giuseppe La Masa class
    "class/567.html", // Curtatone class
    "class/568.html", // Spica class
    "class/569.html", // Orsa class
    "class/570.html", // Animoso class
    "class/571.html", // Ariete class
    "class/572.html", // Gabbiano class
    "class/573.html", // Eritrea class
    "class/574.html", // Azio class
    "class/575.html", // RD class
    "class/576.html", // Vedetta class
    "class/577.html", // Arbe class
    "class/578.html", // Carlo Mirabello class
    "class/579.html", // Kalev class
    "class/580.html", // Ronis class
    "class/581.html", // L (former British) class
    "class/582.html", // Active class
    "class/583.html", // Treasury class
    "class/584.html", // Algonquin class
    "class/585.html", // Owasco class
    "class/586.html", // Argo class
    "class/587.html", // Lake class
    "class/588.html", // Haida class
    "class/589.html", // Wind class
    "class/590.html", // No specific class [Icebreaker]
    "class/591.html", // Ashland class
    "class/592.html", // Casa Grande class
    "class/593.html", // Catskill class
    "class/594.html", // Osage class
    "class/595.html", // LST (Mk 2) class
    "class/596.html", // Tordenskjold class
    "class/597.html", // Eidsvold class
    "class/598.html", // A class
    "class/599.html", // B class
    "class/600.html", // Sleipner class
    "class/601.html", // No specific class [Anti-Aircraft ship]
    "class/602.html", // No specific class [ASW Whaler]
    "class/603.html", // No specific class [MS Whaler]
    "class/604.html", // LSM class
    "class/605.html", // Ch class
    "class/606.html", // Co class
    "class/607.html", // Cr class
    // TODO check "class/608.html",
    // TODO check "class/609.html",
    "class/610.html", // LSM(R) 188 class
    "class/611.html", // LSM(R) 401 class
    "class/612.html", // Insect Class
    "class/613.html", // Tern class
    "class/614.html", // Peterel class
    "class/615.html", // Falcon class
    "class/616.html", // Sandpiper class
    "class/617.html", // Robin class
    "class/618.html", // Scorpion class
    "class/619.html", // Dragonfly class
    "class/620.html", // LST (Mk 3) class
    "class/621.html", // No specific class [Auxiliary minelayer]
    "class/622.html", // Plover class
    "class/623.html", // Linnet class
    "class/624.html", // M 1 class
    "class/625.html", // No specific class [Landing Ships Infantry]
    "class/626.html", // Empire Battleaxe class
    "class/627.html", // Kiwi class
    "class/628.html", // MMS II class
    "class/629.html", // Fairmile A class
    "class/630.html", // Fairmile B class
    "class/631.html", // HDML class
    "class/632.html", // SGB class
    "class/633.html", // MFV 1 class
    "class/634.html", // MFV 425 class
    "class/635.html", // MFV 601 class
    "class/636.html", // MFV 1001 class
    "class/637.html", // MFV 1501 class
    "class/638.html", // Manuka class
    "class/639.html", // BPB 60 feet-type class
    "class/640.html", // Vosper 70 feet-type class
    "class/641.html", // Thornycroft 73 feet-type class
    "class/642.html", // Thornycroft 55 feet-type class
    "class/643.html", // White 73 feet-type class
    "class/644.html", // Thornycroft 75 feet-type class
    "class/645.html", // Vosper 60 feet-type class
    "class/646.html", // Vosper 72 feet-type class
    "class/647.html", // Vosper 73 feet-type class
    "class/648.html", // BPB 72 feet-type class
    "class/649.html", // Fairmile D class
    "class/650.html", // Fairmile D (Modified) class
    "class/651.html", // Camper&Nicholson-type class
    "class/652.html", // Thornycroft experimental-type (MTB 344) class
    "class/653.html", // Thornycroft experimental-type (MTB 345/346) class
    "class/654.html", // BPB experimental-type (MTB 100) class
    "class/655.html", // White experimental-type (MTB 101) class
    "class/656.html", // Vosper experimental-type (MTB 102) class
    "class/657.html", // Vosper experimental-type (MTB 103) class
    "class/658.html", // Thornycroft experimental-type (MTB 104/105) class
    "class/659.html", // Thornycroft experimental-type (MTB 106/107) class
    // TODO check "class/660.html",
    "class/661.html", // Vosper experimental-type (MTB 108(ii)) class
    "class/662.html", // McGruer experimental-type (MTB 109) class
    "class/663.html", // Chantiers Navales de Meulan experimental-type (MTB 108(i)) class
    "class/664.html", // Guardian class
    "class/665.html", // Protector class
    "class/666.html", // BPB 60 feet-type class
    "class/667.html", // BPB 70 feet-type class
    "class/668.html", // BPB 63 feet-type class
    "class/669.html", // White 70 feet-type class
    "class/670.html", // Mercantile conversion class
    "class/671.html", // BPB 70 feet-type (ex: French) class
    "class/672.html", // Higgins 70 feet-type class
    "class/673.html", // BPB 72 feet-type class
    "class/674.html", // VTB-11 (former French) class
    "class/675.html", // Elco 70 feet-type class
    "class/676.html", // Higgins 82 feet-type class
    "class/677.html", // Fairmile C class
    "class/678.html", // Camper&Nicholson-type class
    "class/679.html", // Bachaquero class
    "class/680.html", // Tasajera class
    "class/681.html", // LST (Mk 1) class
    "class/682.html", // LCT (Mk 1) class
    "class/683.html", // LCT (Mk 2) class
    "class/684.html", // LCT (Mk 3) class
    "class/685.html", // LCT (Mk 4) class
    "class/686.html", // LCT (Mk 5) class
    "class/687.html", // LCT (Mk 6) class
    "class/688.html", // LCT (Mk 8) class
    "class/689.html", // LCI 1 class
    "class/690.html", // LCI 351 class
    "class/691.html", // LCS class
    "class/692.html", // No specific class [Armed Yacht]
    "class/693.html", // No specific class [sloop]
    "class/694.html", // No specific class [Auxiliary patrol vessel]
    "class/695.html", // No specific class [Auxiliary patrol trawler]
    "class/696.html", // Lal class
    "class/697.html", // No specific class [Armed boarding vessel]
    "class/698.html" // No specific class [Ocean boarding vessel]
  )

  val filter: JsoupExtractor = new UboatNetClassFilter
  override val name: String = "uboatClass"

  override val dPath: String = "./data/uboat/"
}
