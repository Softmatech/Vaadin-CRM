package com.softmatech.ui;

import com.softmatech.ui.view.dashboard.DashboardView;
import com.softmatech.ui.viewlist.ListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

@CssImport("./styles/shared-styles.css")
@PWA(
        name = "VaadinCRM",
        shortName = "CRM",
        offlineResources = {
                "./styles/offline.css",
                "./images/offline.png"
        }
)
public class MainLayout extends AppLayout {

    public MainLayout(){
        createHeader();
        createDrawer();
    }

    private void createHeader(){
        H1 logo = new H1("Vaadin CRM");
        logo.addClassName("logo");

        Anchor logout = new Anchor("/logout", "Log Out");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");

        addToNavbar(header);
    }

    private  void createDrawer(){
        RouterLink listLink = new RouterLink("List", ListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(listLink,
                new RouterLink("Dashboard", DashboardView.class)
                ));
    }

}
