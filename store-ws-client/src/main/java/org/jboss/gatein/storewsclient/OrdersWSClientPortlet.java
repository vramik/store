package org.jboss.gatein.storewsclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import ws.ObjectFactory;
import ws.Order;
import ws.Order.Item;
import ws.WSOrderServicePortType;
import ws.WSOrderServiceService;

public class OrdersWSClientPortlet extends GenericPortlet {

    private void createOrder(String productName, int quantity) throws MalformedURLException {
        WSOrderServiceService service = new WSOrderServiceService(
                new URL("http://127.0.0.1:8080/store-esb-1.0-SNAPSHOT/ebws/SportStore/WSOrderService?wsdl"));
        WSOrderServicePortType port = service.getWSOrderServicePortType();

        ObjectFactory ofactory = new ObjectFactory();
        Order order = ofactory.createOrder();
        Item item = ofactory.createOrderItem();
        order.getItem().add(item);
        item.setProductName(productName);
        item.setQuantity(quantity);
        port.wsOrderServiceOp(order);
    }

    @Override
    public void doView(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
        String success = (String) rRequest.getParameter("success");
        if (success != null) {
            PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/success.jsp");
            prd.include(rRequest, rResponse);
        } else {
            PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/index.jsp");
            prd.include(rRequest, rResponse);
        }
    }

    @Override
    public void processAction(ActionRequest aRequest, ActionResponse aResponse) throws PortletException, IOException {
        System.out.println("PROCESS_ACTION");
//        String quantity = (String) aRequest.getParameter("quantity");
        String product = (String) aRequest.getParameter("product");
//        createOrder(product, Integer.parseInt(quantity));
        createOrder(product, 10);
        aResponse.setRenderParameter("success", "true");
    }
}
