
package net.mcreator.magica.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.magica.MagicaModVariables;
import net.mcreator.magica.MagicaModElements;

@MagicaModElements.ModElement.Tag
public class MOverlayOverlay extends MagicaModElements.ModElement {
	public MOverlayOverlay(MagicaModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			if ((MagicaModVariables.MapVariables.get(world).Overlay)) {
				Minecraft.getInstance().fontRenderer.drawString("Magica: " + (MagicaModVariables.MapVariables.get(world).GlobalMagic) + "",
						posX + -66, posY + -114, -10092442);
			}
		}
	}
}
