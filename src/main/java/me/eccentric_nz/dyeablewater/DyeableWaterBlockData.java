package me.eccentric_nz.dyeablewater;

import java.util.HashMap;

public class DyeableWaterBlockData {

    public static final HashMap<Integer, String> MODEL_TO_DATA = new HashMap<Integer, String>() {
        {
            // white water level 1
            put(1, "minecraft:mushroom_stem[down=false,east=false,north=false,south=false,up=false,west=true]");
            // white water level 2
            put(2, "minecraft:mushroom_stem[down=false,east=false,north=false,south=false,up=true,west=false]");
            // white water level 3
            put(3, "minecraft:mushroom_stem[down=false,east=false,north=false,south=false,up=true,west=true]");
            // orange water level 1
            put(11, "minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=false,west=false]");
            // orange water level 2
            put(12, "minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=false,west=true]");
            // orange water level 3
            put(13, "minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=true,west=false]");
            // magenta water level 1
            put(21, "minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=true,west=true]");
            // magenta water level 2
            put(22, "minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=false,west=false]");
            // magenta water level 3
            put(23, "minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=false,west=true]");
            // light blue water level 1
            put(31, "minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=true,west=false]");
            // light blue water level 2
            put(32, "minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=true,west=true]");
            // light blue water level 3
            put(33, "minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=false,west=false]");
            // yellow water level 1
            put(41, "minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=false,west=true]");
            // yellow water level 2
            put(42, "minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=true,west=false]");
            // yellow water level 3
            put(43, "minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=true,west=true]");
            // lime water level 1
            put(51, "minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=false,west=false]");
            // lime water level 2
            put(52, "minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=false,west=true]");
            // lime water level 3
            put(53, "minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=true,west=false]");
            // pink water level 1
            put(61, "minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=true,west=true]");
            // pink water level 2
            put(62, "minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=false,west=false]");
            // pink water level 3
            put(63, "minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=false,west=true]");
            // gray water level 1
            put(71, "minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=true,west=false]");
            // gray water level 2
            put(72, "minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=true,west=true]");
            // gray water level 3
            put(73, "minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=false,west=false]");
            // light gray water level 1
            put(81, "minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=false,west=true]");
            // light gray water level 2
            put(82, "minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=true,west=false]");
            // light gray water level 3
            put(83, "minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=true,west=true]");
            // cyan water level 1
            put(91, "minecraft:mushroom_stem[down=false,east=true,north=true,south=true,up=false,west=false]");
            // cyan water level 2
            put(92, "minecraft:mushroom_stem[down=false,east=true,north=true,south=true,up=true,west=false]");
            // cyan water level 3
            put(93, "minecraft:mushroom_stem[down=false,east=true,north=true,south=true,up=true,west=true]");
            // purple water level 1
            put(101, "minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=false,west=false]");
            // purple water level 2
            put(102, "minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=false,west=true]");
            // purple water level 3
            put(103, "minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=true,west=false]");
            // blue water level 1
            put(111, "minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=true,west=true]");
            // blue water level 2
            put(112, "minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=false,west=false]");
            // blue water level 3
            put(113, "minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=false,west=true]");
            // brown water level 1
            put(121, "minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=true,west=false]");
            // brown water level 2
            put(122, "minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=true,west=true]");
            // brown water level 3
            put(123, "minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=false,west=false]");
            // green water level 1
            put(131, "minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=false,west=true]");
            // green water level 2
            put(132, "minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=true,west=false]");
            // green water level 3
            put(133, "minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=true,west=true]");
            // red water level 1
            put(141, "minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=false,west=false]");
            // red water level 2
            put(142, "minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=false,west=true]");
            // red water level 3
            put(143, "minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=true,west=false]");
            // black water level 1
            put(151, "minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=true,west=true]");
            // black water level 2
            put(152, "minecraft:mushroom_stem[down=true,east=true,north=false,south=false,up=false,west=false]");
            // black water level 3
            put(153, "minecraft:mushroom_stem[down=true,east=true,north=false,south=false,up=false,west=true]");
        }
    };

    public static final HashMap<String, Integer> DATA_TO_MODEL = new HashMap<String, Integer>() {
        {
            // white water level 1
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=false,up=false,west=true]", 1);
            // white water level 2
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=false,up=true,west=false]", 2);
            // white water level 3
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=false,up=true,west=true]", 3);
            // orange water level 1
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=false,west=false]", 11);
            // orange water level 2
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=false,west=true]", 12);
            // orange water level 3
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=true,west=false]", 13);
            // magenta water level 1
            put("minecraft:mushroom_stem[down=false,east=false,north=false,south=true,up=true,west=true]", 21);
            // magenta water level 2
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=false,west=false]", 22);
            // magenta water level 3
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=false,west=true]", 23);
            // light blue water level 1
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=true,west=false]", 31);
            // light blue water level 2
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=false,up=true,west=true]", 32);
            // light blue water level 3
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=false,west=false]", 33);
            // yellow water level 1
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=false,west=true]", 41);
            // yellow water level 2
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=true,west=false]", 42);
            // yellow water level 3
            put("minecraft:mushroom_stem[down=false,east=false,north=true,south=true,up=true,west=true]", 43);
            // lime water level 1
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=false,west=false]", 51);
            // lime water level 2
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=false,west=true]", 52);
            // lime water level 3
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=true,west=false]", 53);
            // pink water level 1
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=false,up=true,west=true]", 61);
            // pink water level 2
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=false,west=false]", 62);
            // pink water level 3
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=false,west=true]", 63);
            // gray water level 1
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=true,west=false]", 71);
            // gray water level 2
            put("minecraft:mushroom_stem[down=false,east=true,north=false,south=true,up=true,west=true]", 72);
            // gray water level 3
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=false,west=false]", 73);
            // light gray water level 1
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=false,west=true]", 81);
            // light gray water level 2
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=true,west=false]", 82);
            // light gray water level 3
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=false,up=true,west=true]", 83);
            // cyan water level 1
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=true,up=false,west=false]", 91);
            // cyan water level 2
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=true,up=true,west=false]", 92);
            // cyan water level 3
            put("minecraft:mushroom_stem[down=false,east=true,north=true,south=true,up=true,west=true]", 93);
            // purple water level 1
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=false,west=false]", 101);
            // purple water level 2
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=false,west=true]", 102);
            // purple water level 3
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=true,west=false]", 103);
            // blue water level 1
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=false,up=true,west=true]", 111);
            // blue water level 2
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=false,west=false]", 112);
            // blue water level 3
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=false,west=true]", 113);
            // brown water level 1
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=true,west=false]", 121);
            // brown water level 2
            put("minecraft:mushroom_stem[down=true,east=false,north=false,south=true,up=true,west=true]", 122);
            // brown water level 3
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=false,west=false]", 123);
            // green water level 1
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=false,west=true]", 131);
            // green water level 2
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=true,west=false]", 132);
            // green water level 3
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=false,up=true,west=true]", 133);
            // red water level 1
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=false,west=false]", 141);
            // red water level 2
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=false,west=true]", 142);
            // red water level 3
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=true,west=false]", 143);
            // black water level 1
            put("minecraft:mushroom_stem[down=true,east=false,north=true,south=true,up=true,west=true]", 151);
            // black water level 2
            put("minecraft:mushroom_stem[down=true,east=true,north=false,south=false,up=false,west=false]", 152);
            // black water level 3
            put("minecraft:mushroom_stem[down=true,east=true,north=false,south=false,up=false,west=true]", 153);
        }
    };
}
