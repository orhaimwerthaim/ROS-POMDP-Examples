package JavaSim2POMCP.POMCP.JavaGeneratos.Generated;

import JavaSim2POMCP.POMCP.JavaGeneratos.fixed.ActionsDataStore;
import JavaSim2POMCP.POMCP.JavaGeneratos.fixed.JavaSimulatorUtils;
import POMDP_Solver.Atom;
import JavaSim2POMCP.POMCP.JavaGeneratos.fixed.MiniStateDataStore;
import POMDP_Solver.POMCP_Gate;
import util.Pair;

import java.util.ArrayList;

public class MicroState_Gate implements POMCP_Gate {

    public MicroState_Gate() throws Exception {
        ActionsDataStore.InitActionsDataStore();
    }

    @Override
    public int GetHorizon() {
        return 15;
    }

    @Override
    public float GetDiscount() {
        return 0.99f;
    }

    @Override
    public Atom GetObservationFromROS_Response(String rosResponse) {
        String observationTemplate  = null;
        try {
            observationTemplate =  (new MicroStateObservation(false)).toString();//) domainAndProblem.Generator(domainAndProblem.GetPossibleInitialStates(1).get(0), actionHash)._o1.Observation.toString();
            observationTemplate = observationTemplate.replaceAll("[0-9]+", "0");
        } catch (Exception e) {
            System.out.println("Fatal Exception:" + e);
        }


        String currentStringObservation = observationTemplate;
        String[] observations = rosResponse.split(",");
        for (int i = 0; i < observations.length; i++) {
            String[] bits = observations[i].split(":");
            currentStringObservation = JavaSimulatorUtils.InsertValueToObservation(currentStringObservation, bits[0], bits[1]);
        }
        return new Atom(currentStringObservation.hashCode(), currentStringObservation);
    }


    @Override
    public ArrayList<Atom> GetPossibleInitialStates(int numOfStates) throws Exception {
        ArrayList<Atom> res = new ArrayList<>();
        for(int i=0;i<numOfStates;i++) {
            MicroState ms = new MicroState(true);
            Atom mss = MiniStateDataStore
                    .AddStateAndObservation(ms)[0];
            res.add(mss
            );
        }
        return res;
    }
    @Override
    public ArrayList<Atom> GetStateActions(Atom state) throws Exception {
        ArrayList<Atom> res =  MiniStateDataStore.GetStateValidActions(state);
        return res;
    }

    @Override
    public Atom GetIllegalActionObservation() {
        return MiniStateDataStore.GetObservationAtom(new MicroStateObservation(true));
    }

    @Override
    public boolean IsGoalReached(Atom observation) {
        MicroStateObservation observationReceivedO = MiniStateDataStore.GetObservation(observation);
        return observationReceivedO.goal_reached;
    }

@Override
    public Pair<GeneratorResult, Boolean> Generator(Atom state, Atom action) throws Exception {
        boolean validAction = MiniStateDataStore.GetStateValidActions(state).contains(action);

        Atom nextState = state;
        Atom observation = null;
        double reward = 0;
        if(validAction) {
            Pair<String, String[]> act = ActionsDataStore.GetAction(action);
            ArrayList<Pair<String, String[]>> actions = new ArrayList<>();
            actions.add(act);
            MicroState res = MicroState.NextState(MiniStateDataStore.GetState(state), actions);
            nextState = MiniStateDataStore.GetStateAtom(res.state);
            observation = MiniStateDataStore.GetObservationAtom(res.observation);
            MiniStateDataStore.AddStateAndObservation(res.state, res.observation);
            reward = res.reward;
        }

        GeneratorResult gRes = new GeneratorResult(nextState, observation, reward);
        return new Pair<>(gRes, validAction);
    }
}
