package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpAsset;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;

@Route(value = "sp-asset", layout = DemoLayout.class)
public class SpAssetView extends DemoView {

    public SpAssetView() {
        super(SpAsset.class);

        sectionDivider("Example");

        SpAsset asset = new SpAsset();
        asset.getStyle().set("height", "150px");
        Image image = new Image("https://place.dog/500/500", "Doggo");
        asset.add(image);
        add(asset);

        sectionDivider("File");

        asset = new SpAsset().setVariant(SpAsset.Variant.FILE);
        asset.getStyle().set("height", "150px");
        add(asset);

        sectionDivider("Folder");

        asset = new SpAsset().setVariant(SpAsset.Variant.FOLDER);
        asset.getStyle().set("height", "150px");
        add(asset);

    }

}