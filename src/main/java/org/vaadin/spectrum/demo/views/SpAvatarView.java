package org.vaadin.spectrum.demo.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.vaadin.spectrum.SpAvatar;
import org.vaadin.spectrum.SpDivider;
import org.vaadin.spectrum.SpHtml;
import org.vaadin.spectrum.demo.DemoLayout;
import org.vaadin.spectrum.demo.DemoView;
import org.vaadin.spectrum.properties.HasSizeFluent;

@Route(value = "sp-avatar", layout = DemoLayout.class)
public class SpAvatarView extends DemoView {

    public SpAvatarView() {
        super(SpAvatar.class);

        add(SpHtml.header().text("Sizes").asH3());
        add(new SpDivider().setSize(HasSizeFluent.Size.S));

        int sizes[] = {50, 75, 100, 200, 300, 400, 500, 600, 700};
        String src = "https://ui-avatars.com/api/?background=random";
        for(int size : sizes) {
            Paragraph p = new Paragraph();
            p.getElement().getStyle().set("display", "flex");
            p.getElement().getStyle().set("align-items", "center");
            p.getElement().getStyle().set("justify-content", "space-between");
            p.getElement().getStyle().set("width", "150px");
            p.add(new Span("size: " + size));
            SpAvatar avatar = new SpAvatar().setSize(size).setSrc(src).setLabel("Vaadin!");
            avatar.getStyle().set("border", "1px solid var(--spectrum-accent-content-color-default)");
            p.add(avatar);
            add(p);
        }
    }

}
