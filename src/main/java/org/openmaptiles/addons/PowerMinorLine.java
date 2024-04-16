package org.openmaptiles.addons;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.reader.SourceFeature;
import org.openmaptiles.Layer;
import org.openmaptiles.OpenMapTilesProfile;

public class PowerMinorLine implements Layer, OpenMapTilesProfile.OsmAllProcessor {

  private static final String LAYER_NAME = "power_minor_line";

  @Override
  public String name() {
    return LAYER_NAME;
  }

  @Override
  public void processAllOsm(SourceFeature feature, FeatureCollector features) {
    if (feature.canBeLine() && feature.hasTag("power", "minor_line")) {
      features.line("power_minor_line")
          .setBufferPixels(4)
          .setMinZoom(10)
          .setAttr("class", "line");
    }
  }
}