package cofh.thermalexpansion.block.device;

import cofh.core.network.PacketCoFHBase;
import cofh.core.util.fluid.FluidTankCore;
import cofh.lib.util.helpers.FluidHelper;
import cofh.thermalexpansion.gui.client.machine.GuiWaterGen;
import cofh.thermalexpansion.gui.container.ContainerTEBase;
import cofh.thermalexpansion.init.TEProps;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

public class TileWaterGen extends TileDeviceBase implements ITickable {

	private static final int TYPE = BlockDevice.Type.WATERGEN.getMetadata();

	public static void initialize() {

		defaultSideConfig[TYPE] = new SideConfig();
		defaultSideConfig[TYPE].numConfig = 2;
		defaultSideConfig[TYPE].slotGroups = new int[][] { {}, {} };
		defaultSideConfig[TYPE].allowInsertionSide = new boolean[] { false, false };
		defaultSideConfig[TYPE].allowExtractionSide = new boolean[] { false, false };
		defaultSideConfig[TYPE].sideTex = new int[] { 0, 4 };
		defaultSideConfig[TYPE].defaultSides = new byte[] { 1, 1, 1, 1, 1, 1 };

		GameRegistry.registerTileEntity(TileWaterGen.class, "thermalexpansion:watergen");

		config();
	}

	public static void config() {

	}

	FluidTankCore tank = new FluidTankCore(TEProps.MAX_FLUID_SMALL);
	FluidStack outputBuffer;

	int adjacentSources = -1;
	int outputTrackerFluid;
	boolean inHell;

	public TileWaterGen() {

		super();
		tank.setLock(FluidRegistry.WATER);
	}

	@Override
	public int getType() {

		return TYPE;
	}

	@Override
	public void onNeighborBlockChange() {

		super.onNeighborBlockChange();
		updateAdjacentSources();
	}

	@Override
	public void update() {

		//		if (ServerHelper.isClientWorld(worldObj)) {
		//			return;
		//		}
		//		boolean curActive = isActive;
		//		transferOutputFluid();
		//
		//		if (isActive) {
		//			if (timeCheck()) {
		//				if (adjacentSources >= 2) {
		//					tank.fillLocked(genRate * processMod, true);
		//				} else {
		//					if (worldObj.isRaining() && worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord)) {
		//						tank.fillLocked(genRate * processMod, true);
		//					} else if (passiveGen) {
		//						tank.fillLocked(genRatePassive * processMod, true);
		//					}
		//				}
		//			}
		//			if (!redstoneControlOrDisable()) {
		//				isActive = false;
		//				wasActive = true;
		//				tracker.markTime(worldObj);
		//			}
		//		} else if (redstoneControlOrDisable() && !inHell) {
		//			isActive = true;
		//		}
		//		if (adjacentSources < 0) {
		//			updateAdjacentSources();
		//		}
		//		updateIfChanged(curActive);
	}

	protected void updateAdjacentSources() {

		//		inHell = worldObj.getBiomeGenForCoords(xCoord, zCoord) == BiomeGenBase.hell;
		//
		//		adjacentSources = 0;
		//
		//		Block block = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
		//		int bMeta = worldObj.getBlockMetadata(xCoord, yCoord - 1, zCoord);
		//		if (bMeta == 0 && (block == Blocks.water || block == Blocks.flowing_water)) {
		//			++adjacentSources;
		//		}
		//
		//		block = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
		//		bMeta = worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord);
		//		if (bMeta == 0 && (block == Blocks.water || block == Blocks.flowing_water)) {
		//			++adjacentSources;
		//		}
		//
		//		block = worldObj.getBlock(xCoord - 1, yCoord, zCoord);
		//		bMeta = worldObj.getBlockMetadata(xCoord - 1, yCoord, zCoord);
		//		if (bMeta == 0 && (block == Blocks.water || block == Blocks.flowing_water)) {
		//			++adjacentSources;
		//		}
		//
		//		block = worldObj.getBlock(xCoord + 1, yCoord, zCoord);
		//		bMeta = worldObj.getBlockMetadata(xCoord + 1, yCoord, zCoord);
		//		if (bMeta == 0 && (block == Blocks.water || block == Blocks.flowing_water)) {
		//			++adjacentSources;
		//		}
		//
		//		block = worldObj.getBlock(xCoord, yCoord, zCoord - 1);
		//		bMeta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord - 1);
		//		if (bMeta == 0 && (block == Blocks.water || block == Blocks.flowing_water)) {
		//			++adjacentSources;
		//		}
		//
		//		block = worldObj.getBlock(xCoord, yCoord, zCoord + 1);
		//		bMeta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord + 1);
		//		if (bMeta == 0 && (block == Blocks.water || block == Blocks.flowing_water)) {
		//			++adjacentSources;
		//		}
	}

	protected void transferOutputFluid() {

		if (!enableAutoOutput) {
			return;
		}
		if (tank.getFluidAmount() <= 0) {
			return;
		}
		int side;
		outputBuffer = new FluidStack(tank.getFluid(), Math.min(tank.getFluidAmount(), FLUID_TRANSFER[level]));
		for (int i = outputTrackerFluid + 1; i <= outputTrackerFluid + 6; i++) {
			side = i % 6;

			if (sideCache[side] == 1) {
				int toDrain = FluidHelper.insertFluidIntoAdjacentFluidHandler(this, EnumFacing.VALUES[side], outputBuffer, true);

				if (toDrain > 0) {
					tank.drain(toDrain, true);
					outputTrackerFluid = side;
					break;
				}
			}
		}
	}

	/* GUI METHODS */
	@Override
	public Object getGuiClient(InventoryPlayer inventory) {

		return new GuiWaterGen(inventory, this);
	}

	@Override
	public Object getGuiServer(InventoryPlayer inventory) {

		return new ContainerTEBase(inventory, this);
	}

	@Override
	public FluidTankCore getTank() {

		return tank;
	}

	@Override
	public FluidStack getTankFluid() {

		return tank.getFluid();
	}

	/* NBT METHODS */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {

		super.readFromNBT(nbt);

		inHell = nbt.getBoolean("Hell");
		adjacentSources = nbt.getInteger("Sources");
		outputTrackerFluid = nbt.getInteger("Tracker");
		tank.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

		super.writeToNBT(nbt);

		nbt.setBoolean("Hell", inHell);
		nbt.setInteger("Sources", adjacentSources);
		nbt.setInteger("Tracker", outputTrackerFluid);
		tank.writeToNBT(nbt);

		return nbt;
	}

	/* NETWORK METHODS */
	@Override
	public PacketCoFHBase getGuiPacket() {

		PacketCoFHBase payload = super.getGuiPacket();

		payload.addInt(tank.getFluidAmount());

		return payload;
	}

	@Override
	protected void handleGuiPacket(PacketCoFHBase payload) {

		super.handleGuiPacket(payload);

		tank.getFluid().amount = payload.getInt();
	}

	/* CAPABILITIES */
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		return super.hasCapability(capability, facing) || capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, final EnumFacing from) {

		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(new IFluidHandler() {
				@Override
				public IFluidTankProperties[] getTankProperties() {

					FluidTankInfo info = tank.getInfo();
					return new IFluidTankProperties[] { new FluidTankProperties(info.fluid, info.capacity, false, from != null && sideCache[from.ordinal()] > 0) };
				}

				@Override
				public int fill(FluidStack resource, boolean doFill) {

					return 0;
				}

				@Nullable
				@Override
				public FluidStack drain(FluidStack resource, boolean doDrain) {

					if (from == null || sideCache[from.ordinal()] < 1) {
						return null;
					}
					return tank.drain(resource, doDrain);
				}

				@Nullable
				@Override
				public FluidStack drain(int maxDrain, boolean doDrain) {

					if (from == null || sideCache[from.ordinal()] < 1) {
						return null;
					}
					return tank.drain(maxDrain, doDrain);
				}
			});
		}
		return super.getCapability(capability, from);
	}

}
