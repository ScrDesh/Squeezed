package straight.squeezin.it.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import straight.squeezin.it.client.datagen.ModModelProvider;

public class ModDatagen implements DataGeneratorEntrypoint{
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator){
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModModelProvider::new);
    }
}
