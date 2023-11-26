package project.states;

import project.Game;
import project.controller.Controller;
import project.gui.GUI;
import project.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {

    private final T model;
    private final Viewer<T> viewer;

    private final Controller controller;

    public State(T model)
    {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public T getModel() {
        return model;
    }

    public abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
