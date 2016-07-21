package com.transport.controller;

import com.transport.dto.ManagerDTO;
import com.transport.form.ManagerForm;
import com.transport.service.ManagerService;
import com.transport.service.OrderService;
import com.transport.util.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by AK on 7/7/2016.
 */


@Controller
public class ManagerController {
@Autowired
private OrderService orderService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
        public ModelAndView register(ModelAndView model, @RequestParam Long date) {
        //TODO временно , потом сделать чтобы из календаря отправлялся параметр "date" методом GET с датой того дня, за который нужно вывести все заказы
        date = 1468998208438L;
        List<ManagerDTO> managerDTOs = managerService.getAllManagerDTOByDate(date);

        ManagerForm managerForm = new ManagerForm();
        model.addObject("managerForm", managerForm);
        model.addObject("managerDTOs", managerDTOs);

            FormUtil.setEnumsToOrderModel(model);
            model.setViewName("/manager");

            return model;
        }
//    public ManagerDTO getManagerInfo(ManagerForm managerForm){
//        ManagerDTO managerDTO =  managerInfoHandler.handleManagerForm(managerForm);

//        FormUtil.setEnumsToOrderModel(model);
//        model.setViewName("/manager");
//        return managerDTO;
//    }

    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public ModelAndView register1( ModelAndView model )  {
         model = new ModelAndView();
//        model.addObject("managerForm", new ManagerForm());
        model.setViewName("/manager");
        return model;
    }
}
