package com.facultate.aos.billing.controlers;

import com.facultate.aos.billing.model.Billing;
import com.facultate.aos.billing.proxy.UserManagementProxy;
import com.facultate.aos.billing.proxy.WarehouseProxy;
import com.facultate.aos.billing.repository.BillingRepository;
import com.facultate.aos.billing.service.BillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/bill")
public class BillingControler {

/*    @Autowired
    BillingRepository billingRepository;

    @GetMapping("/signup")
    public String showBilling(Billing billing){
        return "add-billing";
    }

//    public String

    @PostMapping("/addBill")
    public String addBilling(@Valid Billing billing, BindingResult result, Model model)
    {
        if(result.hasErrors()){
            return "add-billing";
        }

        List<Billing> billingList=new ArrayList<>();
        billingList=(List<Billing>)billingRepository.findAll();
        for(Billing bill:billingList)
        {
            if(bill.getNameOfPerson().equals(billing.getNameOfPerson()))
                return  "add-billing";
        }
        billingRepository.save(billing);
        model.addAttribute("billing", billingRepository.findAll());
        return "bill";
    }
    */

    private BillingServiceImpl billingService;

    @Autowired
    public BillingControler(BillingServiceImpl billingService) {
        this.billingService = billingService;
    }

    @Autowired
    public UserManagementProxy userManagementProxy;

    @Autowired
    public WarehouseProxy warehouseProxy;

    @RequestMapping(path = "/getBill/{id}")
    public ResponseEntity<Billing> getBill(@PathVariable(value = "id")Long id)
    {
        return new ResponseEntity<>(billingService.getBill(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/addBill/{id}", method = RequestMethod.GET)
    public ResponseEntity<Billing> addBill(@RequestBody Billing bill)
    {
        return new ResponseEntity<>(billingService.addBill(bill), HttpStatus.OK);
    }

    @RequestMapping(path = "/updateBill/{id}", method = RequestMethod.PUT)
    public ResponseEntity changeYourPassword(@PathVariable(value = "id")Long id,
                                             @Valid @RequestBody Billing myBill){
        return new ResponseEntity<>(billingService.updateBill(id,myBill),HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteBill/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteBill(@PathVariable(value = "id") Long id)
    {
        billingService.deleteBill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/getBill/{idUser}/{idProduct}")
    public Billing getUserManagement(@PathVariable Long idUser, @PathVariable Long idProduct)
    {
        Billing respons= userManagementProxy.retriveUserName(idUser);
        Billing respons2= warehouseProxy.retriveWarehouse(idProduct);
        return new Billing("Mihnea","02.01.2019","Brasov",respons.getName(),respons2.getPrice(),respons2.getQuantity());
    }

    @RequestMapping(path = "/invoice/{idUser}/{idProduct}", method = RequestMethod.POST)
    public ResponseEntity<Billing> buyAnItem(@PathVariable Long idUser, @PathVariable Long idProduct)
    {
        Billing respons= userManagementProxy.retriveUserName(idUser);
        Billing respons2= warehouseProxy.buyAndUpdateStore(idProduct);
        Billing saveBill=new Billing("Mihnea","02.01.2019","Brasov",respons.getName(),respons2.getItemName(),respons2.getWarehouse(),respons2.getPrice(),1);

        return  new ResponseEntity<>(billingService.addBill(saveBill), HttpStatus.OK);
    }

}


