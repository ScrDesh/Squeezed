package straight.squeezin.it

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

object SqueezedClient : ClientModInitializer {
	override fun onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		// Gets Squeezed Out.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLIGHTED_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLIGHTED_VINES, RenderLayer.getCutout());
	}
}