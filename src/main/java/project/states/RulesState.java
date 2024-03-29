package project.states;

import project.controller.Controller;
import project.controller.RuleController;
import project.model.rules.Rule;
import project.viewer.RuleViewer;
import project.viewer.Viewer;


public class RulesState extends State<Rule> {

    public RulesState(Rule model, Viewer<Rule> viewer, Controller<Rule> controller) {
        super(model,viewer,controller);
    }

    @Override
    public Viewer<Rule> getViewer() {return new RuleViewer(getModel());}

    @Override
    public Controller<Rule> getController() {return new RuleController(getModel());}
}
