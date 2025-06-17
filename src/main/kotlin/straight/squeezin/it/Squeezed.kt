package straight.squeezin.it

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.registry.*
import org.slf4j.LoggerFactory
import straight.squeezin.it.statuseffects.ModEffects

object Squeezed : ModInitializer {
    private val logger = LoggerFactory.getLogger("squeezed")
	const val MOD_ID: String = "squeezed"
	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("All Squeezed Out.")

		ServerLifecycleEvents.SERVER_STOPPING.register { server ->
			logger.info("You don't know what they're like, you fall for 'em, you really love 'em, you think this is gonna be the biggest thing since The Graf Zeppelin! Then one morning you wake up, the guy's gone, the saxophone's gone, all that's left behind is a pair of old socks and a tube of toothpaste,\n" +
					"All Squeezed Out.")
		}
		ModBlocks.initialize()
		ModItems.initialize()
		ModEffects.registerEffects()
		StrippableBlockRegistry.register(ModBlocks.BLIGHTED_LOG,ModBlocks.STRIPPED_BLIGHTED_LOG)
		StrippableBlockRegistry.register(ModBlocks.BLIGHTED_WOOD,ModBlocks.STRIPPED_BLIGHTED_WOOD)
	}
}