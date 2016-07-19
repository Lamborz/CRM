package com.transport.controller;

import com.transport.form.ManagerForm;
import com.transport.util.FormUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by AK on 7/7/2016.
 */


@Controller
public class ManagerController {



    @RequestMapping(value = "/manager", method = RequestMethod.GET)
        public ModelAndView register( ModelAndView model) {
        ManagerForm managerForm = new ManagerForm();
        managerForm.setOrderNumber(123);
        model.addObject("managerForm", managerForm);

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
