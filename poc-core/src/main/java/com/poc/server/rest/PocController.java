package com.poc.server.rest;

import com.poc.server.db.PocDao;
import com.poc.shared.model.InputObj;
import com.poc.shared.model.InputObjElem;
import com.poc.shared.model.OutputObj;
import com.poc.shared.model.OutputObjElem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icttb0 on 23/12/2016.
 */
@RestController
@RequestMapping("/srv")
@Transactional
@CrossOrigin
public class PocController {

    private PocDao pocDao;

    public PocController() {
    }

    @Autowired
    public void setPocDao(PocDao pocDao) {
        this.pocDao = pocDao;
    }

    @RequestMapping( method= RequestMethod.GET, path = "/obj")
    public ResponseEntity<OutputObj> getOutputObj(@RequestParam(value="id", defaultValue="1") long id){
        OutputObj outputObj = pocDao.getOutputObj(id);
        List<OutputObjElem> outputObjElems = new ArrayList<OutputObjElem>();
        outputObjElems.add(new OutputObjElem(1,"POC-1"));
        outputObjElems.add(new OutputObjElem(2,"POC-2"));
        outputObj.setOutputObjElems(outputObjElems);
        HttpStatus status = outputObj != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<OutputObj>(outputObj, status);
    }

    @RequestMapping( method=RequestMethod.POST, path = "/obj", consumes="application/json")
    public ResponseEntity<OutputObj> getOutputObj(@RequestBody InputObj inputObj){
        OutputObj outputObj = pocDao.getOutputObj(inputObj.getId());
        if (inputObj.getInputObjElems()!=null && inputObj.getInputObjElems().size()>0){
            List<OutputObjElem> outputObjElems = new ArrayList<OutputObjElem>();
            for(InputObjElem inputObjElem : inputObj.getInputObjElems()){
                outputObjElems.add(new OutputObjElem(inputObjElem.getId(),inputObjElem.getContent()));
            }
            outputObj.setOutputObjElems(outputObjElems);
        }
        HttpStatus status = outputObj != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<OutputObj>(outputObj, status);
    }

    @RequestMapping( method= RequestMethod.GET, path = "/alchemy")
    public ResponseEntity<String> getAlchemyJsJsonData(@RequestParam(value="id", defaultValue="1") long id){
        String sampleJson = "{\n" +
                "  \"comment\": \"Charlize Theron's 'ego' network as GraphJSON "+id+"\",\n" +
                "  \"nodes\": [\n" +
                "    {\n" +
                "      \"caption\": \"Screen Actors Guild Award for Outstanding Performance by a Female Actor in a Miniseries or Television Movie\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595472\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Children of the Corn III: Urban Harvest\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 626470\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Sleepwalking\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 795744\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"That Thing You Do!\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 692946\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Trapped\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 689794\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Head in the Clouds\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 709577\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Waking Up in Reno\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 635905\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Battle in Seattle\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 734583\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Mighty Joe Young\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 662595\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Academy Award for Actress in a Leading Role\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 593781\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Devil's Advocate\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 740763\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Screen Actors Guild Award for Outstanding Performance by a Cast in a Motion Picture\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595440\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Silver Bear for Best Actress\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 601507\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Curse of the Jade Scorpion\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 649461\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"MTV Movie Award for Best Female Performance\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595074\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"15 Minutes\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 634248\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Burning Plain\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 670704\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Life and Death of Peter Sellers\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 794982\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Prometheus\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 608746\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Teen Choice Award for Choice Summer Movie Star: Female\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 599909\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Chicago Film Critics Association Award for Best Actress\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 623686\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Golden Globe Award for Best Supporting Actress - Series, Miniseries or Television Film\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 598027\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Golden Globe Award for Best Actress - Musical or Comedy Film\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595206\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Mad Max: Fury Road\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 804341\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"In the Valley of Elah\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 621675\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Screen Actors Guild Award for Outstanding Performance by a Female Actor in a Leading Role\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 593954\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Golden Raspberry Award for Worst Actress\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 594134\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"East of Havana\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 609415\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Road\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 627715\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Golden Globe Award for Best Actress - Drama Film\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 593776\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Charles Jacobus Theron\",\n" +
                "      \"type\": \"person\",\n" +
                "      \"id\": 314008\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Jackson Theron\",\n" +
                "      \"type\": \"person\",\n" +
                "      \"id\": 314009\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Primetime Emmy Award for Outstanding Supporting Actress in a Miniseries or a Movie\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595684\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Cider House Rules\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 801237\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Astronaut's Wife\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 657006\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Broadcast Film Critics Association Award for Best Actress\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 601849\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Hancock\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 652245\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Charlize Theron\",\n" +
                "      \"root\": true,\n" +
                "      \"id\": 314003\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Stuart Townsend\",\n" +
                "      \"type\": \"person\",\n" +
                "      \"id\": 314004\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Stephan Jenkins\",\n" +
                "      \"type\": \"person\",\n" +
                "      \"id\": 314005\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Benoni, Gauteng\",\n" +
                "      \"type\": \"person\",\n" +
                "      \"id\": 314006\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Gerda Jacoba Aletta Maritz\",\n" +
                "      \"type\": \"person\",\n" +
                "      \"id\": 314007\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Æon Flux\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 663286\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Snow White and the Huntsman\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 599907\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Young Adult\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 661733\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Reindeer Games\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 761000\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Monster\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 729778\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Legend of Bagger Vance\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 804616\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Teen Choice Award for Choice Hissy Fit: Film\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 599908\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Yards\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 781638\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"MTV Movie Award for Best Kiss\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595095\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Celebrity\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 611629\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Astro Boy\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 818608\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"North Country\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 784437\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"2 Days in the Valley\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 615556\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Satellite Award for Best Actress – Motion Picture\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595704\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Trial and Error\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 799574\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"National Society of Film Critics Award for Best Actress\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595702\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Independent Spirit Award for Best Female Lead\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595703\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Two Eyes Staring\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 788889\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Sweet November\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 811358\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Teen Choice Movie Award: Villain\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 595082\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Satellite Award for Best Supporting Actress – Drama\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 602151\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"San Francisco Film Critics Circle Award for Best Actress\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 669827\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Independent Spirit Award for Best First Feature\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 599387\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"The Italian Job\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 817380\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Hollywood Confidential\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 711550\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"Men of Honor\",\n" +
                "      \"type\": \"movie\",\n" +
                "      \"id\": 682763\n" +
                "    },\n" +
                "    {\n" +
                "      \"caption\": \"BAFTA Award for Best Actress in a Leading Role\",\n" +
                "      \"type\": \"award\",\n" +
                "      \"id\": 594478\n" +
                "    }\n" +
                "  ],\n" +
                "  \"edges\": [\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 621675,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 818608,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 601849,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 649461,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 669827,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 608746,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 593954,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595702,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 601849,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595095,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 729778,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595703,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 811358,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595472,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 661733,\n" +
                "      \"caption\": \"PRODUCED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 784437,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 634248,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 662595,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 804616,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595703,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 626470,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 599387,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 599908,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 682763,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595702,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 788889,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 657006,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 795744,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 593781,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 594478,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 594134,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595074,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 692946,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 740763,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314005,\n" +
                "      \"target\": 314003,\n" +
                "      \"caption\": \"PARTNER_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 711550,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595440,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 801237,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 599907,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 761000,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 781638,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 670704,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 609415,\n" +
                "      \"caption\": \"PRODUCED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 314009,\n" +
                "      \"caption\": \"PARENT_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 652245,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 661733,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 602151,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 635905,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 799574,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 593781,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 817380,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 611629,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 729778,\n" +
                "      \"caption\": \"PRODUCED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 709577,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 804341,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 627715,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 794982,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 623686,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595082,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 689794,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 788889,\n" +
                "      \"caption\": \"PRODUCED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314007,\n" +
                "      \"target\": 314003,\n" +
                "      \"caption\": \"PARENT_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 593776,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 734583,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 598027,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 601507,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 599909,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 314004,\n" +
                "      \"caption\": \"PARTNER_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 663286,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 314006,\n" +
                "      \"caption\": \"BORN_AT\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 615556,\n" +
                "      \"caption\": \"ACTED_IN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314004,\n" +
                "      \"target\": 314003,\n" +
                "      \"caption\": \"PARTNER_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314008,\n" +
                "      \"target\": 314003,\n" +
                "      \"caption\": \"PARENT_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 314005,\n" +
                "      \"caption\": \"PARTNER_OF\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 795744,\n" +
                "      \"caption\": \"PRODUCED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595704,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 670704,\n" +
                "      \"caption\": \"EXEC_PRODUCED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 593954,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595206,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 593776,\n" +
                "      \"caption\": \"RECEIVED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595704,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 595684,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": 314003,\n" +
                "      \"target\": 599387,\n" +
                "      \"caption\": \"NOMINATED\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return new ResponseEntity<String>(sampleJson, HttpStatus.OK);
    }
}
