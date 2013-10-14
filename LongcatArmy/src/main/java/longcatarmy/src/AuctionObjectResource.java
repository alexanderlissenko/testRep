/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.AuctionObjectProxy;
import longcat.auction.src.Customer;

/**
 *
 * @author Alexander Lissenko
 */

@Path("auction/{auctionId}")    //eventuellt annan path, unik för varje auctionobject
public class AuctionObjectResource {
    
    @Inject
    private SuperSiteBean site;   
    
    AuctionObject auction;
    private UriInfo uriInfo;
    Long id; //*************************************************OBS! byt ut när id går att fås

    
    /*@PUT
    @Path("??") //TODO
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response setBid(@FormParam("newBid") Double newBid ) {
        //kopplas ihop med att kolla att budet är valid
    }*/
    
    @GET
    @Path("/title")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getTitle() {
        auction = site.getAuctionCatalogue().getAuction(id);
        AuctionObjectProxy prox = new AuctionObjectProxy(auction);
        String t = prox.getTitle(); 
        PrimitiveJSONWrapper<String> wrapTitle = new PrimitiveJSONWrapper<String>(t);
        return Response.ok(wrapTitle).build();
    }
    
    @GET
    @Path("/info")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getInfo() {
        auction = site.getAuctionCatalogue().getAuction(id);
        AuctionObjectProxy prox = new AuctionObjectProxy(auction);
        String t = prox.getInfo(); //byts till site.något.getInfo
        PrimitiveJSONWrapper<String> wrapInfo = new PrimitiveJSONWrapper<String>(t);
        return Response.ok(wrapInfo).build();
    }
    
    @GET
    @Path("/price")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getPrice() {
        auction = site.getAuctionCatalogue().getAuction(id);
        AuctionObjectProxy prox = new AuctionObjectProxy(auction);
        Double d = prox.getPrice(); //byts till site.något.getPrice
        PrimitiveJSONWrapper<Double> wrapPrice = new PrimitiveJSONWrapper<Double>(d);
        return Response.ok(wrapPrice).build();
    }
    
    
    //kan behöva wrappas på annat sätt, osäker på om Date är primitiv typ
    @GET
    @Path("/expire")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getExpire() {
        auction = site.getAuctionCatalogue().getAuction(id);
        AuctionObjectProxy prox = new AuctionObjectProxy(auction);
        Date d = prox.getExpire(); //byts till site.något.getExpire
        PrimitiveJSONWrapper<Date> wrapExp = new PrimitiveJSONWrapper<Date>(d);
        return Response.ok(wrapExp).build();
    }
    
    
    //getId troligtvis onödig för resource, id används bara för att hålla koll på rätt objekt
    /*@GET
    @Path("id")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getId() {
        Long i = objectP.getId(); //byts till site.något.getId
        PrimitiveJSONWrapper<Long> wrapId = new PrimitiveJSONWrapper<Long>(i);
        return Response.ok(wrapId).build();
    }*/
    
    
    
    @GET
    @Path("/bidder") 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getBidder() {
        List<HashMap> list = site.getAuctionCatalogue().getAuction(id).getBidder(); //byts till site.något.getBidder
        GenericEntity<List<HashMap>> ge = new GenericEntity<List<HashMap>>(list){};
        return Response.ok(ge).build();
    }
    
    
    //tas bort om vi inte implementerar någon flagg-funktion
    @GET
    @Path("/flags") 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getFlagList() {
        List<Customer> cList = site.getAuctionCatalogue().getAuction(id).getFlagList(); //byts till site.något.getFlagList
        GenericEntity<List<Customer>> gc = new GenericEntity<List<Customer>>(cList){};
        return Response.ok(gc).build();
    }

}
