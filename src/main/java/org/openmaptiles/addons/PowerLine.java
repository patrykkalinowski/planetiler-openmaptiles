package org.openmaptiles.addons;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.reader.SourceFeature;
import org.openmaptiles.Layer;
import org.openmaptiles.OpenMapTilesProfile;

public class PowerLine implements Layer, OpenMapTilesProfile.OsmAllProcessor {

  private static final String LAYER_NAME = "power_line";

  @Override
  public String name() {
    return LAYER_NAME;
  }

  @Override
  public void processAllOsm(SourceFeature feature, FeatureCollector features) {
    if (feature.canBeLine() && feature.hasTag("power", "line")) {
      features.line("power_line")
          .setBufferPixels(4)
          .setMinZoom(10)
          .setAttr("class", "line");
    }
  }
}