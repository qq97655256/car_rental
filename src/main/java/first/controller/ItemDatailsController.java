package first.controller;

import first.pojo.ItemDetails;
import first.pojo.User;
import first.service.ItemDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemDatailsController {
    @Autowired
    private ItemDatailsService itemDatailsService;
    @RequestMapping("/itemall")
    private List<ItemDetails> itemall(HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        List<ItemDetails> itemall=null;
        if (user instanceof User){
            User user1=(User) user;
             itemall = itemDatailsService.itemall(user1.getUid());
        }else {

        }
        return itemall;

    }
@RequestMapping("/Itemdelete/{oid}")
    private String Itemdelete(@PathVariable("oid") Integer oid){
        int itemdelete = itemDatailsService.Itemdelete(oid);
        if(itemdelete==1){
            return "success";
        }else{
            return "warning";
        }
    }
}
