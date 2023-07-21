package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.SpPopover;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.utils.Placement;

@Route(value = "sp-popover", layout = DemoLayout.class)
public class SpPopoverView extends DemoView {

    public SpPopoverView() {
        super(SpPopover.class);

        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Auctor augue mauris augue neque gravida.";

        sectionDivider("Example");

        Div div = new Div();
        div.setHeight("200px");
        div.setWidthFull();
        SpPopover popover = new SpPopover();
        popover.add(SpHtml.header().text("Dialog title").asH3());
        HtmlContainer p = SpHtml.paragraph().text(lorem).build();
        p.setWidth("300px");
        popover.add(p);
        popover.setOpen(true);
        div.add(popover);
        add(div);

        sectionDivider("Example - dialog");

        div = new Div();
        div.setHeight("250px");
        div.setWidthFull();
        SpPopover popover2 = new SpPopover();
        popover2.add(SpHtml.header().text("Dialog title").asH3());
        p = SpHtml.paragraph().text(lorem).build();
        p.setWidth("300px");
        popover2.add(p);
        popover2.setDialog(true);
        popover2.setOpen(true);
        div.add(popover2);
        add(div);

        sectionDivider("Example - dialog, tip");

        div = new Div();
        div.setHeight("250px");
        div.setWidthFull();
        SpPopover popover3 = new SpPopover();
        popover3.add(SpHtml.header().text("Dialog title").asH3());
        p = SpHtml.paragraph().text(lorem).build();
        p.setWidth("300px");
        popover3.add(p);
        popover3.setDialog(true);
        popover3.setTip(true);
        popover3.setOpen(true);
        popover3.setPlacement(Placement.LEFT);
        div.add(popover3);
        add(div);

    }

}