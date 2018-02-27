package com.noesis.peopleware.controller;

import java.beans.PropertyEditor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.noesis.peopleware.model.*;
import com.noesis.peopleware.service.*;

@Controller
public class PeopleWareController {

	private static final Logger logger = Logger.getLogger(PeopleWareController.class);

	public PeopleWareController() {
	    System.out.println("PeopleWareController()");
	}

    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private DegreeService degreeService;
    @Autowired
    private OfferService offerService;
     
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Set.class, "degrees", new CustomCollectionEditor(Set.class){
            protected Object convertElement(Object element){
                Integer id = null;
 
                if(element instanceof String && !((String)element).equals("")){
                    try{
                        id = Integer.parseInt((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Integer) {
                    id = (Integer) element;
                }
 
                return id != null ? degreeService.getDegree(id) : null;
            }
        });
        
        binder.registerCustomEditor(Set.class, "skills", new CustomCollectionEditor(Set.class){
            protected Object convertElement(Object element){
                Integer id = null;
 
                if(element instanceof String && !((String)element).equals("")){
                    try{
                        id = Integer.parseInt((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Integer) {
                    id = (Integer) element;
                }
 
                return id != null ? skillService.getSkill(id) : null;
            }
        });
    }
    
    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
//        List<Employee> listEmployee = employeeService.getAllEmployees();
//        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }
    
    /*
     * Applicants
     */
    
    /**
     * List all applicants
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/applicant")
    public ModelAndView listApplicant(ModelAndView model) throws IOException{
        List<Applicant> listApplicant = applicantService.getAllApplicants();
        model.addObject("listApplicant", listApplicant);
        model.setViewName("applicant/ApplicantList");
        
        return model;
    }
    
    /**
     * Returns form to add a new applicant
     * @param model
     * @return
     */
    @RequestMapping(value="/applicant/add", method = RequestMethod.GET)
    public String newApplicant(Model model){
        Applicant applicant = new Applicant();
        Set<Degree> degreeList = new HashSet<Degree>(degreeService.getAllDegrees());
        Set<Skill> skillList = new HashSet<Skill>(skillService.getAllSkills());
        
        model.addAttribute("applicant", applicant);
        model.addAttribute("skillList", skillList);
        model.addAttribute("degreeList", degreeList);
        
        return "applicant/ApplicantForm";
    }  
    
    /**
     * View Applicant
     * @param model
     * @return
     */
    @RequestMapping(value="/applicant/view", method = RequestMethod.GET)
    public ModelAndView editApplicant(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Applicant applicant = applicantService.getApplicant(id);
        ArrayList<Skill> skillsList = new ArrayList<>(applicant.getSkills());
                
        ModelAndView model = new ModelAndView("applicant/ApplicantView");
        model.addObject("applicant", applicant);
        model.addObject("skills", applicant.getSkills());
        return model;
    }

    /**
     * Save the new applicant in the database
     * @param applicant
     * @return
     */
    @RequestMapping(value = "/applicant/save", method = RequestMethod.POST)
    public ModelAndView saveApplicant(@ModelAttribute Applicant applicant) {
        System.out.println("We are /applicant/save");
        System.out.println(applicant);
        if (applicant.getId() == 0) { // if employee id is 0 then creating the employee other updating the employee
            applicantService.addApplicant(applicant);
        } else {
            applicantService.updateApplicant(applicant);
        }
        return new ModelAndView("redirect:/applicant");
    }   
    
    /*
     * Offer
     */
    
    /**
     * List all offers
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/offer")
    public ModelAndView listOffer(ModelAndView model) throws IOException{
        List<Offer> listOffer = offerService.getAllOffers();
        model.addObject("listOffer", listOffer);
        model.setViewName("offer/OfferList");
        
        return model;
    }
    
    /**
     * Returns form to add a new offer
     * @param model
     * @return
     */
    @RequestMapping(value="/offer/add", method = RequestMethod.GET)
    public String newOffer(Model model){
        Offer offer = new Offer();
        Set<Degree> degreeList = new HashSet<Degree>(degreeService.getAllDegrees());
        Set<Skill> skillList = new HashSet<Skill>(skillService.getAllSkills());
        
        model.addAttribute("offer", offer);
        model.addAttribute("skillList", skillList);
        model.addAttribute("degreeList", degreeList);
        
        return "offer/OfferForm";
    }  
    
    /**
     * View Offer
     * @param model
     * @return
     */
    @RequestMapping(value="/offer/view", method = RequestMethod.GET)
    public ModelAndView editOffer(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Offer offer = offerService.getOffer(id);
        System.out.println("skills: " + offer.getSkills());

        ArrayList<Skill> skillsList = new ArrayList<>(offer.getSkills());
                
        ModelAndView model = new ModelAndView("offer/OfferView");
        model.addObject("offer", offer);
        model.addObject("skills", offer.getSkills());
        return model;
    }

    /**
     * Save the new offer in the database
     * @param offer
     * @return
     */
//    @RequestMapping(value="/offer/bestApplicant", method = RequestMethod.GET)
//    public ModelAndView bestApplicant(HttpServletRequest request){
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        Offer offer = offerService.getOffer(id);
//        Set<Applicant> applicants = new HashSet<>();        
//        ArrayList<Applicant> bestApplicants = new ArrayList<Applicant>();
//        
//        ModelAndView model = new ModelAndView("offer/BestApplicantsView");
//        model.addObject("bestApplicants", bestApplicants);
//
//        //Get all the Applicants for this offer
//        applicants = offer.getApplicants();
//        
//        if(applicants.size == 0) {
//            //It will returns an empty list of applicants, the view will show an error message
//            return model;
//        }
//        else {
//            do {    
//                Integer maxCoef = 0;
//                Applicant bestApplicant = new Applicant();
//                for (Applicant applicant : applicants) {
//                    Integer coef = suitability(applicant, offer);
//                    if(coef > maxCoef) {
//                        bestApplicant = applicant;
//                        maxCoef = coef;
//                    }
//                }
//                bestApplicants.add(bestApplicant);
//                applicants.remove(bestApplicant);                            
//            }while(applicants.size() > 0);
//            return model;
//        }
//    }     

    /**
     * Save the new offer in the database
     * @param offer
     * @return
     */
    @RequestMapping(value = "/offer/BestApplicants", method = RequestMethod.POST)
    public ModelAndView saveOffer(@ModelAttribute Offer offer) {
        
        System.out.println("We are /offer/save");
        System.out.println(offer);
        if (offer.getId() == 0) { // if employee id is 0 then creating the employee other updating the employee
            offerService.addOffer(offer);
        } else {
            offerService.updateOffer(offer);
        }
        return new ModelAndView("redirect:/offer");
    } 
    
	
}