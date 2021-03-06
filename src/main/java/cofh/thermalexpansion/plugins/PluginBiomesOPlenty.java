package cofh.thermalexpansion.plugins;

import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.util.managers.device.TapperManager;
import cofh.thermalexpansion.util.managers.machine.*;
import cofh.thermalfoundation.init.TFFluids;
import cofh.thermalfoundation.item.ItemMaterial;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class PluginBiomesOPlenty extends PluginTEBase {

	public static final String MOD_ID = "biomesoplenty";
	public static final String MOD_NAME = "Biomes O' Plenty";

	public PluginBiomesOPlenty() {

		super(MOD_ID, MOD_NAME);
	}

	@Override
	public void initializeDelegate() {

		ItemStack sandWhite = getItemStack("white_sand", 1, 0);
		ItemStack driedSand = getItemStack("dried_sand", 1, 0);
		ItemStack sandstoneWhite = getItemStack("white_sandstone", 1, 0);

		ItemStack logYellowAutumn = new ItemStack(Blocks.LOG, 1, 2);
		ItemStack logOrangeAutumn = new ItemStack(Blocks.LOG2, 1, 1);
		ItemStack logBamboo = getItemStack("bamboo", 1, 0);
		ItemStack logMagic = getItemStack("log_1", 1, 5);
		ItemStack logUmbral = getItemStack("log_0", 1, 6);
		// Dead
		ItemStack logFir = getItemStack("log_0", 1, 7);
		// Ethereal

		ItemStack logOrigin = new ItemStack(Blocks.LOG, 1, 0);
		ItemStack logCherry = getItemStack("log_0", 1, 5);
		// White Cherry
		ItemStack logMaple = new ItemStack(Blocks.LOG, 1, 0);
		ItemStack logHellbark = getItemStack("log_2", 1, 7);
		ItemStack logFloweringOak = new ItemStack(Blocks.LOG, 1, 0);
		ItemStack logJacaranda = getItemStack("log_3", 1, 4);
		ItemStack logSacredOak = getItemStack("log_0", 1, 4);

		ItemStack logMangrove = getItemStack("log_1", 1, 6);
		ItemStack logPalm = getItemStack("log_1", 1, 7);
		ItemStack logRedwood = getItemStack("log_2", 1, 4);
		ItemStack logWillow = getItemStack("log_2", 1, 5);
		ItemStack logPine = getItemStack("log_2", 1, 6);
		ItemStack logMahogany = getItemStack("log_3", 1, 5);
		ItemStack logEbony = getItemStack("log_3", 1, 6);
		ItemStack logEucalyptus = getItemStack("log_3", 1, 7);

		ItemStack saplingYellowAutumn = getItemStack("sapling_0", 1, 0);
		ItemStack saplingOrangeAutumn = getItemStack("sapling_0", 1, 1);
		ItemStack saplingBamboo = getItemStack("sapling_0", 1, 2);
		ItemStack saplingMagic = getItemStack("sapling_0", 1, 3);
		ItemStack saplingUmbran = getItemStack("sapling_0", 1, 4);
		ItemStack saplingDead = getItemStack("sapling_0", 1, 5);
		ItemStack saplingFir = getItemStack("sapling_0", 1, 6);
		ItemStack saplingEthereal = getItemStack("sapling_0", 1, 7);

		ItemStack saplingOrigin = getItemStack("sapling_1", 1, 0);
		ItemStack saplingPinkCherry = getItemStack("sapling_1", 1, 1);
		ItemStack saplingWhiteCherry = getItemStack("sapling_1", 1, 2);
		ItemStack saplingMaple = getItemStack("sapling_1", 1, 3);
		ItemStack saplingHellback = getItemStack("sapling_1", 1, 4);
		ItemStack saplingFloweringOak = getItemStack("sapling_1", 1, 5);
		ItemStack saplingJacaranda = getItemStack("sapling_1", 1, 6);
		ItemStack saplingSacredOak = getItemStack("sapling_1", 1, 7);

		ItemStack saplingMangrove = getItemStack("sapling_2", 1, 0);
		ItemStack saplingPalm = getItemStack("sapling_2", 1, 1);
		ItemStack saplingRedwood = getItemStack("sapling_2", 1, 2);
		ItemStack saplingWillow = getItemStack("sapling_2", 1, 3);
		ItemStack saplingPine = getItemStack("sapling_2", 1, 4);
		ItemStack saplingMahogany = getItemStack("sapling_2", 1, 5);
		ItemStack saplingEbony = getItemStack("sapling_2", 1, 6);
		ItemStack saplingEucalyptus = getItemStack("sapling_2", 1, 7);

		ItemStack plankSacredOak = getItemStack("planks_0", 1, 0);
		ItemStack plankCherry = getItemStack("planks_0", 1, 1);
		ItemStack plankUmbran = getItemStack("planks_0", 1, 2);
		ItemStack plankFir = getItemStack("planks_0", 1, 3);
		ItemStack plankEthereal = getItemStack("planks_0", 1, 4);
		ItemStack plankMagic = getItemStack("planks_0", 1, 5);
		ItemStack plankMangrove = getItemStack("planks_0", 1, 6);
		ItemStack plankPalm = getItemStack("planks_0", 1, 7);
		ItemStack plankRedwood = getItemStack("planks_0", 1, 8);
		ItemStack plankWillow = getItemStack("planks_0", 1, 9);
		ItemStack plankPine = getItemStack("planks_0", 1, 10);
		ItemStack plankHellbark = getItemStack("planks_0", 1, 11);
		ItemStack plankJacaranda = getItemStack("planks_0", 1, 12);
		ItemStack plankMahogany = getItemStack("planks_0", 1, 13);
		ItemStack plankEbony = getItemStack("planks_0", 1, 14);
		ItemStack plankEucalyptus = getItemStack("planks_0", 1, 15);

		Block bamboo = getBlock("bamboo");
		Block blockLog0 = getBlock("log_0");
		Block blockLog1 = getBlock("log_1");
		Block blockLog2 = getBlock("log_2");
		Block blockLog3 = getBlock("log_3");

		Block blockLeaves0 = getBlock("leaves_0");
		Block blockLeaves1 = getBlock("leaves_1");
		Block blockLeaves2 = getBlock("leaves_2");
		Block blockLeaves3 = getBlock("leaves_3");
		Block blockLeaves4 = getBlock("leaves_4");
		Block blockLeaves5 = getBlock("leaves_5");

		/* PULVERIZER */
		{
			int energy = PulverizerManager.DEFAULT_ENERGY * 3 / 4;

			for (int i = 0; i < 3; i++) {
				PulverizerManager.addRecipe(energy, new ItemStack(getBlock("white_sandstone"), 1, i), ItemHelper.cloneStack(sandWhite, 2), ItemMaterial.dustNiter, 40);
			}
			PulverizerManager.addRecipe(energy, new ItemStack(getBlock("white_sandstone_stairs")), ItemHelper.cloneStack(sandWhite, 2), ItemMaterial.dustNiter, 20);
			PulverizerManager.addRecipe(energy, new ItemStack(getBlock("other_slab"), 1, 1), ItemHelper.cloneStack(sandWhite, 1), ItemMaterial.dustNiter, 20);

			/* PLANTS */
			energy = PulverizerManager.DEFAULT_ENERGY / 2;

			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 11), new ItemStack(Items.DYE, 4, 1));
			PulverizerManager.addRecipe(energy, getItemStack("flower_1", 1, 5), new ItemStack(Items.DYE, 4, 1));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 8), new ItemStack(Items.DYE, 4, 5));
			PulverizerManager.addRecipe(energy, getItemStack("flower_1", 1, 0), new ItemStack(Items.DYE, 4, 5));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 1), new ItemStack(Items.DYE, 4, 6));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 3), new ItemStack(Items.DYE, 4, 6));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 0), new ItemStack(Items.DYE, 4, 7));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 12), new ItemStack(Items.DYE, 4, 8));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 6), new ItemStack(Items.DYE, 4, 9));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 13), new ItemStack(Items.DYE, 4, 9));
			PulverizerManager.addRecipe(energy, getItemStack("flower_1", 1, 3), new ItemStack(Items.DYE, 4, 9));
			PulverizerManager.addRecipe(energy, getItemStack("mushroom", 1, 3), new ItemStack(Items.DYE, 4, 10));
			PulverizerManager.addRecipe(energy, getItemStack("flower_1", 1, 1), new ItemStack(Items.DYE, 4, 11));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 4), new ItemStack(Items.DYE, 4, 12));
			PulverizerManager.addRecipe(energy, getItemStack("flower_1", 1, 4), new ItemStack(Items.DYE, 4, 12));
			PulverizerManager.addRecipe(energy, getItemStack("double_plant", 1, 0), new ItemStack(Items.DYE, 4, 12));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 7), new ItemStack(Items.DYE, 4, 13));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 5), new ItemStack(Items.DYE, 4, 14));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 15), new ItemStack(Items.DYE, 4, 14));
			PulverizerManager.addRecipe(energy, getItemStack("flower_1", 1, 2), getItemStack("blue_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("mushroom", 1, 2), getItemStack("blue_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("plant_1", 1, 4), getItemStack("brown_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("double_plant", 1, 1), getItemStack("brown_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("mushroom", 1, 4), getItemStack("brown_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("pinecone", 1, 0), getItemStack("brown_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 9), getItemStack("white_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 14), getItemStack("white_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 2), getItemStack("black_dye", 4));
			PulverizerManager.addRecipe(energy, getItemStack("flower_0", 1, 10), getItemStack("black_dye", 4));
		}

		/* SAWMILL */
		{
			/* BOATS */
			SawmillManager.addBoatRecipe(getItemStack("boat_sacred_oak"), plankSacredOak);
			SawmillManager.addBoatRecipe(getItemStack("boat_cherry"), plankCherry);
			SawmillManager.addBoatRecipe(getItemStack("boat_umbran"), plankUmbran);
			SawmillManager.addBoatRecipe(getItemStack("boat_fir"), plankFir);
			SawmillManager.addBoatRecipe(getItemStack("boat_ethereal"), plankEthereal);
			SawmillManager.addBoatRecipe(getItemStack("boat_magic"), plankMagic);
			SawmillManager.addBoatRecipe(getItemStack("boat_mangrove"), plankMangrove);
			SawmillManager.addBoatRecipe(getItemStack("boat_palm"), plankPalm);
			SawmillManager.addBoatRecipe(getItemStack("boat_redwood"), plankRedwood);
			SawmillManager.addBoatRecipe(getItemStack("boat_willow"), plankWillow);
			SawmillManager.addBoatRecipe(getItemStack("boat_pine"), plankPine);
			SawmillManager.addBoatRecipe(getItemStack("boat_hellbark"), plankHellbark);
			SawmillManager.addBoatRecipe(getItemStack("boat_jacaranda"), plankJacaranda);
			SawmillManager.addBoatRecipe(getItemStack("boat_mahogany"), plankMahogany);
			SawmillManager.addBoatRecipe(getItemStack("boat_ebony"), plankEbony);
			SawmillManager.addBoatRecipe(getItemStack("boat_eucalyptus"), plankEucalyptus);

			/* DOORS */
			SawmillManager.addDoorRecipe(getItemStack("sacred_oak_door"), plankSacredOak);
			SawmillManager.addDoorRecipe(getItemStack("cherry_door"), plankCherry);
			SawmillManager.addDoorRecipe(getItemStack("umbran_door"), plankUmbran);
			SawmillManager.addDoorRecipe(getItemStack("fir_door"), plankFir);
			SawmillManager.addDoorRecipe(getItemStack("ethereal_door"), plankEthereal);
			SawmillManager.addDoorRecipe(getItemStack("magic_door"), plankMagic);
			SawmillManager.addDoorRecipe(getItemStack("mangrove_door"), plankMangrove);
			SawmillManager.addDoorRecipe(getItemStack("palm_door"), plankPalm);
			SawmillManager.addDoorRecipe(getItemStack("redwood_door"), plankRedwood);
			SawmillManager.addDoorRecipe(getItemStack("willow_door"), plankWillow);
			SawmillManager.addDoorRecipe(getItemStack("pine_door"), plankPine);
			SawmillManager.addDoorRecipe(getItemStack("hellbark_door"), plankHellbark);
			SawmillManager.addDoorRecipe(getItemStack("jacaranda_door"), plankJacaranda);
			SawmillManager.addDoorRecipe(getItemStack("mahogany_door"), plankMahogany);
			SawmillManager.addDoorRecipe(getItemStack("ebony_door"), plankEbony);
			SawmillManager.addDoorRecipe(getItemStack("eucalyptus_door"), plankEucalyptus);

			/* FENCES */
			SawmillManager.addFenceRecipe(getItemStack("sacred_oak_fence"), plankSacredOak);
			SawmillManager.addFenceRecipe(getItemStack("cherry_fence"), plankCherry);
			SawmillManager.addFenceRecipe(getItemStack("umbran_fence"), plankUmbran);
			SawmillManager.addFenceRecipe(getItemStack("fir_fence"), plankFir);
			SawmillManager.addFenceRecipe(getItemStack("ethereal_fence"), plankEthereal);
			SawmillManager.addFenceRecipe(getItemStack("magic_fence"), plankMagic);
			SawmillManager.addFenceRecipe(getItemStack("mangrove_fence"), plankMangrove);
			SawmillManager.addFenceRecipe(getItemStack("palm_fence"), plankPalm);
			SawmillManager.addFenceRecipe(getItemStack("redwood_fence"), plankRedwood);
			SawmillManager.addFenceRecipe(getItemStack("willow_fence"), plankWillow);
			SawmillManager.addFenceRecipe(getItemStack("pine_fence"), plankPine);
			SawmillManager.addFenceRecipe(getItemStack("hellbark_fence"), plankHellbark);
			SawmillManager.addFenceRecipe(getItemStack("jacaranda_fence"), plankJacaranda);
			SawmillManager.addFenceRecipe(getItemStack("mahogany_fence"), plankMahogany);
			SawmillManager.addFenceRecipe(getItemStack("ebony_fence"), plankEbony);
			SawmillManager.addFenceRecipe(getItemStack("eucalyptus_fence"), plankEucalyptus);

			/* FENCE GATES */
			SawmillManager.addFenceGateRecipe(getItemStack("sacred_oak_fence_gate"), plankSacredOak);
			SawmillManager.addFenceGateRecipe(getItemStack("cherry_fence_gate"), plankCherry);
			SawmillManager.addFenceGateRecipe(getItemStack("umbran_fence_gate"), plankUmbran);
			SawmillManager.addFenceGateRecipe(getItemStack("fir_fence_gate"), plankFir);
			SawmillManager.addFenceGateRecipe(getItemStack("ethereal_fence_gate"), plankEthereal);
			SawmillManager.addFenceGateRecipe(getItemStack("magic_fence_gate"), plankMagic);
			SawmillManager.addFenceGateRecipe(getItemStack("mangrove_fence_gate"), plankMangrove);
			SawmillManager.addFenceGateRecipe(getItemStack("palm_fence_gate"), plankPalm);
			SawmillManager.addFenceGateRecipe(getItemStack("redwood_fence_gate"), plankRedwood);
			SawmillManager.addFenceGateRecipe(getItemStack("willow_fence_gate"), plankWillow);
			SawmillManager.addFenceGateRecipe(getItemStack("pine_fence_gate"), plankPine);
			SawmillManager.addFenceGateRecipe(getItemStack("hellbark_fence_gate"), plankHellbark);
			SawmillManager.addFenceGateRecipe(getItemStack("jacaranda_fence_gate"), plankJacaranda);
			SawmillManager.addFenceGateRecipe(getItemStack("mahogany_fence_gate"), plankMahogany);
			SawmillManager.addFenceGateRecipe(getItemStack("ebony_fence_gate"), plankEbony);
			SawmillManager.addFenceGateRecipe(getItemStack("eucalyptus_fence_gate"), plankEucalyptus);

			/* STAIRS */
			SawmillManager.addStairsRecipe(getItemStack("sacred_oak_stairs"), plankSacredOak);
			SawmillManager.addStairsRecipe(getItemStack("cherry_stairs"), plankCherry);
			SawmillManager.addStairsRecipe(getItemStack("umbran_stairs"), plankUmbran);
			SawmillManager.addStairsRecipe(getItemStack("fir_stairs"), plankFir);
			SawmillManager.addStairsRecipe(getItemStack("ethereal_stairs"), plankEthereal);
			SawmillManager.addStairsRecipe(getItemStack("magic_stairs"), plankMagic);
			SawmillManager.addStairsRecipe(getItemStack("mangrove_stairs"), plankMangrove);
			SawmillManager.addStairsRecipe(getItemStack("palm_stairs"), plankPalm);
			SawmillManager.addStairsRecipe(getItemStack("redwood_stairs"), plankRedwood);
			SawmillManager.addStairsRecipe(getItemStack("willow_stairs"), plankWillow);
			SawmillManager.addStairsRecipe(getItemStack("pine_stairs"), plankPine);
			SawmillManager.addStairsRecipe(getItemStack("hellbark_stairs"), plankHellbark);
			SawmillManager.addStairsRecipe(getItemStack("jacaranda_stairs"), plankJacaranda);
			SawmillManager.addStairsRecipe(getItemStack("mahogany_stairs"), plankMahogany);
			SawmillManager.addStairsRecipe(getItemStack("ebony_stairs"), plankEbony);
			SawmillManager.addStairsRecipe(getItemStack("eucalyptus_stairs"), plankEucalyptus);
		}

		/* INSOLATOR */
		{
			String plant = "waterlily";
			for (int i = 0; i < 4; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 2, i), ItemStack.EMPTY, 0);
			}
			plant = "plant_0";
			for (int i = 0; i < 16; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 3, i), ItemStack.EMPTY, 0);
			}
			plant = "plant_1";
			for (int i = 0; i < 11; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 3, i), ItemStack.EMPTY, 0);
			}
			plant = "double_plant";
			for (int i = 0; i < 3; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 3, i), ItemStack.EMPTY, 0);
			}
			plant = "mushroom";
			for (int i = 0; i < 6; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 2, i), ItemStack.EMPTY, 0);
			}
			plant = "flower_0";
			for (int i = 0; i < 16; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 3, i), ItemStack.EMPTY, 0);
			}
			plant = "flower_1";
			for (int i = 0; i < 6; i++) {
				InsolatorManager.addDefaultRecipe(getItemStack(plant, 1, i), getItemStack(plant, 3, i), ItemStack.EMPTY, 0);
			}
			InsolatorManager.addDefaultRecipe(getItemStack("flower_vine"), getItemStack("flower_vine", 2), ItemStack.EMPTY, 0);
			InsolatorManager.addDefaultRecipe(getItemStack("ivy"), getItemStack("ivy", 2), ItemStack.EMPTY, 0);
			InsolatorManager.addDefaultRecipe(getItemStack("tree_moss"), getItemStack("tree_moss", 2), ItemStack.EMPTY, 0);
			InsolatorManager.addDefaultRecipe(getItemStack("willow_vine"), getItemStack("willow_vine", 2), ItemStack.EMPTY, 0);

			InsolatorManager.addDefaultTreeRecipe(saplingYellowAutumn, ItemHelper.cloneStack(logYellowAutumn, 6), saplingYellowAutumn);
			InsolatorManager.addDefaultTreeRecipe(saplingOrangeAutumn, ItemHelper.cloneStack(logOrangeAutumn, 6), saplingOrangeAutumn);
			InsolatorManager.addDefaultTreeRecipe(saplingBamboo, ItemHelper.cloneStack(logBamboo, 6), saplingBamboo);
			InsolatorManager.addDefaultTreeRecipe(saplingMagic, ItemHelper.cloneStack(logMagic, 6), saplingMagic);
			InsolatorManager.addDefaultTreeRecipe(saplingUmbran, ItemHelper.cloneStack(logUmbral, 6), saplingUmbran);
			// Dead
			InsolatorManager.addDefaultTreeRecipe(saplingFir, ItemHelper.cloneStack(logFir, 6), saplingFir);
			// Ethereal

			InsolatorManager.addDefaultTreeRecipe(saplingOrigin, ItemHelper.cloneStack(logOrigin, 6), saplingOrigin);
			InsolatorManager.addDefaultTreeRecipe(saplingPinkCherry, ItemHelper.cloneStack(logCherry, 6), saplingPinkCherry);
			InsolatorManager.addDefaultTreeRecipe(saplingWhiteCherry, ItemHelper.cloneStack(logCherry, 6), saplingWhiteCherry);
			InsolatorManager.addDefaultTreeRecipe(saplingMaple, ItemHelper.cloneStack(logMaple, 6), saplingMaple);
			InsolatorManager.addDefaultTreeRecipe(saplingHellback, ItemHelper.cloneStack(logHellbark, 2), saplingHellback);
			InsolatorManager.addDefaultTreeRecipe(saplingFloweringOak, ItemHelper.cloneStack(logFloweringOak, 6), saplingFloweringOak);
			InsolatorManager.addDefaultTreeRecipe(saplingJacaranda, ItemHelper.cloneStack(logJacaranda, 6), saplingJacaranda);
			// Sacred Oak InsolatorManager.addDefaultTreeRecipe(saplingSacredOak, ItemHelper.cloneStack(logSacredOak, 6), saplingSacredOak);

			InsolatorManager.addDefaultTreeRecipe(saplingMangrove, ItemHelper.cloneStack(logMangrove, 6), saplingMangrove);
			InsolatorManager.addDefaultTreeRecipe(saplingPalm, ItemHelper.cloneStack(logPalm, 6), saplingPalm);
			// InsolatorManager.addDefaultTreeRecipe(saplingRedwood, ItemHelper.cloneStack(logRedwood, 6), saplingRedwood);
			InsolatorManager.addDefaultTreeRecipe(saplingWillow, ItemHelper.cloneStack(logWillow, 6), saplingWillow);
			InsolatorManager.addDefaultTreeRecipe(saplingPine, ItemHelper.cloneStack(logPine, 6), saplingPine);
			InsolatorManager.addDefaultTreeRecipe(saplingMahogany, ItemHelper.cloneStack(logMahogany, 6), saplingMahogany);
			InsolatorManager.addDefaultTreeRecipe(saplingEbony, ItemHelper.cloneStack(logEbony, 6), saplingEbony);
			InsolatorManager.addDefaultTreeRecipe(saplingEucalyptus, ItemHelper.cloneStack(logEucalyptus, 6), saplingEucalyptus);
		}

		/* TRANSPOSER */
		{
			int energy = TransposerManager.DEFAULT_ENERGY;
			FluidStack water = new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME);

			TransposerManager.addFillRecipe(energy, new ItemStack(Blocks.DIRT), getItemStack("mud"), water, false);
			TransposerManager.addFillRecipe(energy, getItemStack("dirt"), getItemStack("mud"), water, false);
			TransposerManager.addFillRecipe(energy, getItemStack("dried_sand"), new ItemStack(Blocks.SAND), water, false);
		}

		/* EXTRUDER */
		{
			ExtruderManager.addRecipeSedimentary(ExtruderManager.DEFAULT_ENERGY * 4, sandWhite, new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, 1500));
			ExtruderManager.addRecipeSedimentary(ExtruderManager.DEFAULT_ENERGY * 8, sandstoneWhite, new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME * 2));
		}

		/* TAPPER */
		{
			// Yellow Autumn
			// Orange Autumn
			TapperManager.addStandardMapping(logBamboo, new FluidStack(FluidRegistry.WATER, 25));
			TapperManager.addStandardMapping(logMagic, new FluidStack(TFFluids.fluidResin, 25));    // TODO: Mana
			TapperManager.addStandardMapping(logUmbral, new FluidStack(TFFluids.fluidResin, 50));
			// Dead
			TapperManager.addStandardMapping(logFir, new FluidStack(TFFluids.fluidResin, 50));
			// Ethereal

			// Origin
			TapperManager.addStandardMapping(logCherry, new FluidStack(TFFluids.fluidSap, 50));
			// White Cherry
			// Maple
			// TapperManager.addStandardMapping(logHellbark, new FluidStack(TFFluids.fluidSap, 50));
			// Flowering Oak
			TapperManager.addStandardMapping(logJacaranda, new FluidStack(TFFluids.fluidSap, 50));
			// TapperManager.addStandardMapping(logSacredOak, new FluidStack(TFFluids.fluidSap, 50));       // TODO: Allow?

			TapperManager.addStandardMapping(logMangrove, new FluidStack(TFFluids.fluidResin, 50));
			// TapperManager.addStandardMapping(logPalm, new FluidStack(TFFluids.fluidSap, 25));            // TODO: Allow?
			// TapperManager.addStandardMapping(logRedwood, new FluidStack(TFFluids.fluidResin, 50));       // TODO: Allow?
			TapperManager.addStandardMapping(logWillow, new FluidStack(TFFluids.fluidResin, 50));
			TapperManager.addStandardMapping(logPine, new FluidStack(TFFluids.fluidResin, 100));
			TapperManager.addStandardMapping(logMahogany, new FluidStack(TFFluids.fluidResin, 25));
			TapperManager.addStandardMapping(logEbony, new FluidStack(TFFluids.fluidResin, 25));
			TapperManager.addStandardMapping(logEucalyptus, new FluidStack(TFFluids.fluidResin, 50));

			addLeafMapping(Blocks.LOG, 2, blockLeaves0, 8);
			addLeafMapping(Blocks.LOG2, 1, blockLeaves0, 9);
			addLeafMapping(bamboo, 0, blockLeaves0, 10);
			addLeafMapping(blockLog1, 5, blockLeaves0, 11);
			addLeafMapping(blockLog0, 6, blockLeaves1, 0);
			// Dead
			addLeafMapping(blockLog0, 7, blockLeaves1, 10);
			// Ethereal

			addLeafMapping(Blocks.LOG, 0, blockLeaves2, 8);
			addLeafMapping(blockLog0, 5, blockLeaves2, 9);
			addLeafMapping(blockLog0, 5, blockLeaves2, 10);
			addLeafMapping(Blocks.LOG, 0, blockLeaves2, 11);
			// Hellbark addLeafMapping(blockLog2, 7, blockLeaves3, 8);
			addLeafMapping(Blocks.LOG, 0, blockLeaves3, 9);
			addLeafMapping(blockLog3, 4, blockLeaves3, 10);
			// Sacred Oak addLeafMapping(blockLog0, 4, blockLeaves3, 11);

			addLeafMapping(blockLog1, 6, blockLeaves4, 8);
			// Palm addLeafMapping(blockLog1, 7, blockLeaves4, 9);
			// Redwood addLeafMapping(blockLog2, 4, blockLeaves4, 10);
			addLeafMapping(blockLog2, 5, blockLeaves4, 11);
			addLeafMapping(blockLog2, 6, blockLeaves5, 8);
			addLeafMapping(blockLog3, 5, blockLeaves5, 9);
			addLeafMapping(blockLog3, 6, blockLeaves5, 10);
			addLeafMapping(blockLog3, 7, blockLeaves5, 11);
		}

		/* EXTRUDER */
		{
			ExtruderManager.addRecipeSedimentary(ExtruderManager.DEFAULT_ENERGY * 4, sandWhite, new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, 1500));
			ExtruderManager.addRecipeSedimentary(ExtruderManager.DEFAULT_ENERGY * 4, driedSand, new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, 1000));
			ExtruderManager.addRecipeSedimentary(ExtruderManager.DEFAULT_ENERGY * 8, sandstoneWhite, new FluidStack(FluidRegistry.LAVA, 0), new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME * 2));
		}
	}

}
