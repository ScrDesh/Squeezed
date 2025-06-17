package straight.squeezin.it

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.registry.*
import org.slf4j.LoggerFactory

object Squeezed : ModInitializer {
    private val logger = LoggerFactory.getLogger("squeezed")
	const val MOD_ID: String = "squeezed"
	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		ModBlocks.initialize()
		ModItems.initialize()
		StrippableBlockRegistry.register(ModBlocks.BLIGHTED_LOG,ModBlocks.STRIPPED_BLIGHTED_LOG)
		StrippableBlockRegistry.register(ModBlocks.BLIGHTED_WOOD,ModBlocks.STRIPPED_BLIGHTED_WOOD)
	}
}