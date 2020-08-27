package JavaSim2POMCP.POMCP.JavaGeneratos.Generated;

import JavaSim2POMCP.POMCP.JavaGeneratos.fixed.ParameterizedVar;
import util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MicroState {
    public int reward;
    static HashSet<String> outer_elv_button;
    static HashSet<String> robot;
    static HashSet<String> obj;
    static HashSet<String> discrete_location;

    public static MicroStateIntermediate interm = new MicroStateIntermediate();

    public static ArrayList<ParameterizedVar<Boolean>> connected;
    public static ArrayList<ParameterizedVar<Boolean>> buttton_associated;
    public static ArrayList<ParameterizedVar<Boolean>> is_elevator;
    public MicroStateObservation observation;
    public MicroStateState state;

    static Random rand = new Random();

    static
    {
        outer_elv_button = new HashSet<>();
        outer_elv_button.add("up");
        outer_elv_button.add("down");

        robot = new HashSet<>();
        robot.add("armadillo");

        obj = new HashSet<>();
        obj.add("can");
        obj.add("table1");
        obj.add("table2");
        obj.add("table3");
        obj.add("table4");

        discrete_location = new HashSet<>();
        discrete_location.add("lab211");
        discrete_location.add("outside_lab211");
        discrete_location.add("auditorium");
        discrete_location.add("corridor");
        discrete_location.add("near_elevator1");
        discrete_location.add("elevator1");
        discrete_location.add("open_area");
        discrete_location.add("corner_area");

        connected = new ArrayList<>();

        for (String i0: discrete_location)
        {
            for (String i1: discrete_location)
            {
                        ArrayList<String> a1 =
                                new ArrayList<String>(Arrays.asList(i0, i1));
                        boolean value = (i0.equals("open_area") && i1.equals("near_elevator1")) ? true : (i0.equals("open_area") && i1.equals("auditorium")) ? true : (i0.equals("open_area") && i1.equals("corridor")) ? true : (i0.equals("open_area") && i1.equals("corner_area")) ? true : (i0.equals("corner_area") && i1.equals("outside_lab211")) ? true : (i0.equals("lab211") && i1.equals("outside_lab211")) ? true : (i0.equals("corner_area") && i1.equals("auditorium")) ? true : (i0.equals("corner_area") && i1.equals("corridor")) ? true : (i0.equals("corner_area") && i1.equals("near_elevator1")) ? true : (i0.equals("near_elevator1") && i1.equals("corridor")) ? true : (i0.equals("near_elevator1") && i1.equals("auditorium")) ? true : (i0.equals("corridor") && i1.equals("auditorium")) ? true : (i0.equals("near_elevator1") && i1.equals("elevator1")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                connected.add(p);
            }
        }
        buttton_associated = new ArrayList<>();

        for (String i0: outer_elv_button)
        {
            for (String i1: discrete_location)
            {
                        ArrayList<String> a1 =
                                new ArrayList<String>(Arrays.asList(i0, i1));
                        boolean value = (i0.equals("up") && i1.equals("near_elevator1")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                buttton_associated.add(p);
            }
        }
        is_elevator = new ArrayList<>();

        for (String i0: discrete_location)
        {
                    ArrayList<String> a1 =
                            new ArrayList<String>(Arrays.asList(i0));
                    boolean value = (i0.equals("elevator1")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                is_elevator.add(p);
        }
    }

    //Pair<String:'var name',String:'var type, can be bool/int'>

    private int GetRandomOption()
    {
        float[] options = new float[]{0.60f,0.40f};
        Random rand = new Random();
        float fRand = rand.nextFloat();
        float current = 0.0f;
        for(int i=0;;i++)
        {
            if(current <= fRand && fRand <= options[i] + current)
            {
                return i;
            }
            current += options[i];
        }
    }
    public MicroState(boolean initState) {
        state = new MicroStateState();
        observation = new MicroStateObservation();

        if (initState) {
            int numOfOptions = 2;
            int selectedOpt= numOfOptions > 0 ? GetRandomOption() : -1;
        state.object_at = new ArrayList<>();

        for (String i0: obj)
        {
            for (String i1: discrete_location)
            {
                        ArrayList<String> a1 =
                                new ArrayList<String>(Arrays.asList(i0, i1));
                        boolean value = (i0.equals("table1") && i1.equals("corridor")) ? true : (i0.equals("table2") && i1.equals("lab211")) ? true : (i0.equals("table3") && i1.equals("auditorium")) ? true : (i0.equals("table4") && i1.equals("outside_lab211")) ? true : ((selectedOpt == 0) && i0.equals("can") && i1.equals("corridor")) ? true : ((selectedOpt == 1) && i0.equals("can") && i1.equals("outside_lab211")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.object_at.add(p);
            }
        }
        state.possible_location = new ArrayList<>();

        for (String i0: obj)
        {
            for (String i1: discrete_location)
            {
                        ArrayList<String> a1 =
                                new ArrayList<String>(Arrays.asList(i0, i1));
                        boolean value = (i0.equals("can") && i1.equals("corridor")) ? true : (i0.equals("can") && i1.equals("outside_lab211")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.possible_location.add(p);
            }
        }
        state.near = new ArrayList<>();

        for (String i0: robot)
        {
            for (String i1: discrete_location)
            {
                        ArrayList<String> a1 =
                                new ArrayList<String>(Arrays.asList(i0, i1));
                        boolean value = (i0.equals("armadillo") && i1.equals("near_elevator1")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.near.add(p);
            }
        }
        state.hand_empty = new ArrayList<>();

        for (String i0: robot)
        {
                    ArrayList<String> a1 =
                            new ArrayList<String>(Arrays.asList(i0));
                    boolean value = true;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.hand_empty.add(p);
        }
        state.door_is_open = new ArrayList<>();

        for (String i0: discrete_location)
        {
                    ArrayList<String> a1 =
                            new ArrayList<String>(Arrays.asList(i0));
                    boolean value = false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.door_is_open.add(p);
        }
        state.pickable = new ArrayList<>();

        for (String i0: obj)
        {
                    ArrayList<String> a1 =
                            new ArrayList<String>(Arrays.asList(i0));
                    boolean value = (i0.equals("can")) ? true : false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.pickable.add(p);
        }
        state.holding = new ArrayList<>();

        for (String i0: robot)
        {
            for (String i1: obj)
            {
                        ArrayList<String> a1 =
                                new ArrayList<String>(Arrays.asList(i0, i1));
                        boolean value = false;

                ParameterizedVar<Boolean> p = new ParameterizedVar<Boolean>(a1, value);
                state.holding.add(p);
            }
        }
        }
    }

    public static MicroState NextState(MicroStateState state, ArrayList<Pair<String,String[]>> actions)
    {
        MicroState next = new MicroState(false);
        MicroStateIntermediate interm = CalcIntermediate(state, actions);
        next.state = CalcNextStateVariables(state, interm, actions);
        next.observation = CalcObservation(state, interm, next.state, actions);
        next.reward = CalcReward(state, interm, next.observation, next.state, actions);
        return next;
    }

    public static ArrayList<Pair<String,String[]>> GetAllPossibleActions() {
        ArrayList<Pair<String, String[]>> actions = new ArrayList<>();

        ArrayList<Pair<String, String[]>> validActions = new ArrayList<>();
        for (String p0 :
                robot) {
        for (String p1 :
                discrete_location) {
        for (String p2 :
                outer_elv_button) {
                    actions.add(new Pair<>("push_button", new String[]{p0,p1,p2}));
                }
                }
                }

        for (String p0 :
                robot) {
        for (String p1 :
                discrete_location) {
        for (String p2 :
                discrete_location) {
                    actions.add(new Pair<>("robot_navigation", new String[]{p0,p1,p2}));
                }
                }
                }

        for (String p0 :
                robot) {
        for (String p1 :
                obj) {
        for (String p2 :
                discrete_location) {
                    actions.add(new Pair<>("pick_unknown", new String[]{p0,p1,p2}));
                }
                }
                }

        for (String p0 :
                robot) {
        for (String p1 :
                obj) {
        for (String p2 :
                discrete_location) {
                    actions.add(new Pair<>("sense_object", new String[]{p0,p1,p2}));
                }
                }
                }

        for (String p0 :
                robot) {
        for (String p1 :
                obj) {
        for (String p2 :
                obj) {
        for (String p3 :
                discrete_location) {
                    actions.add(new Pair<>("place_unknown", new String[]{p0,p1,p2,p3}));
                }
                }
                }
                }

        return actions;
        }

    private static ArrayList<Pair<String,String[]>> GetValidpush_buttonActions(MicroStateState ms)
    {
        ArrayList<Pair<String,String[]>> validActions = new ArrayList<>();
        for (String outer_elv_button2 :
                outer_elv_button) {
            for (String discrete_location3 :
                    discrete_location) {
                for (String robot1 :
                        robot) {
                    if(((buttton_associated.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(outer_elv_button2) && x.params.get(1).equals(discrete_location3)).count() > 0))&&((ms.near.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1) && x.params.get(1).equals(discrete_location3)).count() > 0))&&((ms.hand_empty.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1)).count() > 0)))
                        {validActions.add(new Pair<>("push_button", new String[]{robot1,discrete_location3,outer_elv_button2}));
        }
                }
            }
        }
        return validActions;
    }

    private static ArrayList<Pair<String,String[]>> GetValidrobot_navigationActions(MicroStateState ms)
    {
        ArrayList<Pair<String,String[]>> validActions = new ArrayList<>();
        for (String robot1 :
                robot) {
            for (String discrete_location3 :
                    discrete_location) {
                for (String discrete_location2 :
                        discrete_location) {
                    if(((ms.near.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1) && x.params.get(1).equals(discrete_location3)).count() > 0))&&(((connected.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(discrete_location3) && x.params.get(1).equals(discrete_location2)).count() > 0))||((connected.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(discrete_location2) && x.params.get(1).equals(discrete_location3)).count() > 0)))&&(((!((is_elevator.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(discrete_location2)).count() > 0))))||((ms.door_is_open.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(discrete_location3)).count() > 0))))
                        {validActions.add(new Pair<>("robot_navigation", new String[]{robot1,discrete_location3,discrete_location2}));
        }
                }
            }
        }
        return validActions;
    }

    private static ArrayList<Pair<String,String[]>> GetValidpick_unknownActions(MicroStateState ms)
    {
        ArrayList<Pair<String,String[]>> validActions = new ArrayList<>();
        for (String robot1 :
                robot) {
            for (String obj2 :
                    obj) {
                for (String discrete_location3 :
                        discrete_location) {
                    if(((ms.hand_empty.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1)).count() > 0))&&((ms.object_at.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(obj2) && x.params.get(1).equals(discrete_location3)).count() > 0))&&((ms.near.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1) && x.params.get(1).equals(discrete_location3)).count() > 0))&&((ms.pickable.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(obj2)).count() > 0)))
                        {validActions.add(new Pair<>("pick_unknown", new String[]{robot1,obj2,discrete_location3}));
        }
                }
            }
        }
        return validActions;
    }

    private static ArrayList<Pair<String,String[]>> GetValidsense_objectActions(MicroStateState ms)
    {
        ArrayList<Pair<String,String[]>> validActions = new ArrayList<>();
        for (String robot1 :
                robot) {
            for (String discrete_location3 :
                    discrete_location) {
                for (String obj2 :
                        obj) {
                    if(((ms.near.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1) && x.params.get(1).equals(discrete_location3)).count() > 0))&&((ms.possible_location.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(obj2) && x.params.get(1).equals(discrete_location3)).count() > 0))&&((ms.pickable.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(obj2)).count() > 0)))
                        {validActions.add(new Pair<>("sense_object", new String[]{robot1,obj2,discrete_location3}));
        }
                }
            }
        }
        return validActions;
    }

    private static ArrayList<Pair<String,String[]>> GetValidplace_unknownActions(MicroStateState ms)
    {
        ArrayList<Pair<String,String[]>> validActions = new ArrayList<>();
        for (String robot1 :
                robot) {
            for (String obj3 :
                    obj) {
                for (String obj2 :
                        obj) {
                    for (String discrete_location4 :
                            discrete_location) {
                        if(((ms.holding.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1) && x.params.get(1).equals(obj3)).count() > 0))&&((ms.object_at.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(obj2) && x.params.get(1).equals(discrete_location4)).count() > 0))&&((ms.near.stream().filter(x-> x.value.equals(true) && x.params.get(0).equals(robot1) && x.params.get(1).equals(discrete_location4)).count() > 0)))
                            {validActions.add(new Pair<>("place_unknown", new String[]{robot1,obj3,obj2,discrete_location4}));
        }
                    }
                }
            }
        }
        return validActions;
    }
    public static ArrayList<Pair<String,String[]>> GetStateActions(MicroStateState ms) {
        ArrayList<Pair<String, String[]>> validActions = new ArrayList<>();
        validActions.addAll(GetValidpush_buttonActions(ms));
        validActions.addAll(GetValidrobot_navigationActions(ms));
        validActions.addAll(GetValidpick_unknownActions(ms));
        validActions.addAll(GetValidsense_objectActions(ms));
        validActions.addAll(GetValidplace_unknownActions(ms));
        return validActions;
    }

    public static String ActionToString(Pair<String,String[]> action)
    {
        String params = action._o2.length == 0 ? "" : ("(" +
                Arrays.stream(action._o2)
                        .collect(Collectors.joining(",")) + ")");
        return action._o1 + params;
    }


    private static int CalcReward(MicroStateState state, MicroStateIntermediate interm, MicroStateObservation observation, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        int reward = 0;
        if(observation.goal_reached)
        {
            reward +=1400;
        }

        for (Pair<String,String[]> action : actions) {
            if(action._o1.equals("push_button"))
                reward +=-160;
        }

        for (Pair<String,String[]> action : actions) {
            if(action._o1.equals("robot_navigation"))
                reward +=-120;
        }

        for (Pair<String,String[]> action : actions) {
            if(action._o1.equals("pick_unknown"))
                reward +=-100;
        }

        for (Pair<String,String[]> action : actions) {
            if(action._o1.equals("sense_object"))
                reward +=-120;
        }

        for (Pair<String,String[]> action : actions) {
            if(action._o1.equals("place_unknown"))
                reward +=-100;
        }

        return reward;
    }

    
    private static MicroStateObservation CalcObservation(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        MicroStateObservation observation = new MicroStateObservation();
        observation.goal_reached = getGoal_reached(state, interm, next, actions);
        observation.obsrv_push_button = getObsrv_push_button(state, interm, next, actions);
        observation.obsrv_robot_navigation = getObsrv_robot_navigation(state, interm, next, actions);
        observation.obsrv_pick_unknown = getObsrv_pick_unknown(state, interm, next, actions);
        observation.obsrv_sense_object = getObsrv_sense_object(state, interm, next, actions);
        observation.obsrv_place_unknown = getObsrv_place_unknown(state, interm, next, actions);
        return observation;
    }


    private static int getObsrv_push_button(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        return interm.success_push_button ? 1:0;
    }

    private static int getObsrv_robot_navigation(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        return interm.success_robot_navigation ? 1:0;
    }

    private static int getObsrv_pick_unknown(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        return interm.success_pick_unknown ? 1:0;
    }

    private static int getObsrv_sense_object(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        if(!interm.success_sense_object)return 0;
        int result = 0;
        result += interm.success_sense_object ? 1 : 0;
        boolean exists = false;
        for (Pair<String,String[]> action : actions) {
            if (!action._o1.equals("sense_object")) continue;
            String location = action._o2[2];

            if (interm.success_sense_object) {
                for (ParameterizedVar<Boolean> object_atO :
                        next.object_at) {
                    if (object_atO.params.get(1).equals(location) )
                        if (!object_atO.value) {
                            result += rand.nextFloat() < 0.80 ? 0 : 1;
                            break;
                        }
                        else {
                            result += rand.nextFloat() < 0.80 ? 1 : 0;
                            break;
                        }
                    }
                }
            }
        return result;
    }

    private static int getObsrv_place_unknown(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String,String[]>> actions)
    {
        return interm.success_place_unknown ? 1:0;
    }

    private static MicroStateIntermediate CalcIntermediate(MicroStateState currentState, ArrayList<Pair<String,String[]>> actions) {
        MicroStateIntermediate interm = new MicroStateIntermediate();
        interm.success_push_button = getIntsuccess_push_button(actions, currentState);
        interm.success_robot_navigation = getIntsuccess_robot_navigation(actions, currentState);
        interm.success_pick_unknown = getIntsuccess_pick_unknown(actions, currentState);
        interm.success_sense_object = getIntsuccess_sense_object(actions, currentState);
        interm.success_place_unknown = getIntsuccess_place_unknown(actions, currentState);
        return interm;
    }


    private static boolean getIntsuccess_push_button(ArrayList<Pair<String,String[]>> actions, MicroStateState currentState) {
        for (Pair<String,String[]> action : actions) {
            if(!action._o1.equals("push_button"))continue;

                return rand.nextFloat() < 0.93;
            }
        return false;
    }


    private static boolean getIntsuccess_robot_navigation(ArrayList<Pair<String,String[]>> actions, MicroStateState currentState) {
        for (Pair<String,String[]> action : actions) {
            if(!action._o1.equals("robot_navigation"))continue;

                return rand.nextFloat() < 0.93;
            }
        return false;
    }


    private static boolean getIntsuccess_pick_unknown(ArrayList<Pair<String,String[]>> actions, MicroStateState currentState) {
        for (Pair<String,String[]> action : actions) {
            if(!action._o1.equals("pick_unknown"))continue;

                return rand.nextFloat() < 0.93;
            }
        return false;
    }


    private static boolean getIntsuccess_sense_object(ArrayList<Pair<String,String[]>> actions, MicroStateState currentState) {
        for (Pair<String,String[]> action : actions) {
            if(!action._o1.equals("sense_object"))continue;

                return rand.nextFloat() < 0.99;
            }
        return false;
    }


    private static boolean getIntsuccess_place_unknown(ArrayList<Pair<String,String[]>> actions, MicroStateState currentState) {
        for (Pair<String,String[]> action : actions) {
            if(!action._o1.equals("place_unknown"))continue;

                return rand.nextFloat() < 0.93;
            }
        return false;
    }


    private static MicroStateState CalcNextStateVariables(MicroStateState state, MicroStateIntermediate interm, ArrayList<Pair<String,String[]>> actions)
    {
        MicroStateState next = new MicroStateState();
        for (ParameterizedVar<Boolean> object_at0:
                state.object_at) {
            boolean o = getNextobject_at(object_at0, actions, state, interm);
            next.object_at.add(new ParameterizedVar<Boolean>(object_at0.params, o));
        }

        for (ParameterizedVar<Boolean> possible_location0:
                state.possible_location) {
            boolean o = getNextpossible_location(possible_location0, actions, state, interm);
            next.possible_location.add(new ParameterizedVar<Boolean>(possible_location0.params, o));
        }

        for (ParameterizedVar<Boolean> near0:
                state.near) {
            boolean o = getNextnear(near0, actions, state, interm);
            next.near.add(new ParameterizedVar<Boolean>(near0.params, o));
        }

        for (ParameterizedVar<Boolean> hand_empty0:
                state.hand_empty) {
            boolean o = getNexthand_empty(hand_empty0, actions, state, interm);
            next.hand_empty.add(new ParameterizedVar<Boolean>(hand_empty0.params, o));
        }

        for (ParameterizedVar<Boolean> door_is_open0:
                state.door_is_open) {
            boolean o = getNextdoor_is_open(door_is_open0, actions, state, interm);
            next.door_is_open.add(new ParameterizedVar<Boolean>(door_is_open0.params, o));
        }

        for (ParameterizedVar<Boolean> pickable0:
                state.pickable) {
            boolean o = getNextpickable(pickable0, actions, state, interm);
            next.pickable.add(new ParameterizedVar<Boolean>(pickable0.params, o));
        }

        for (ParameterizedVar<Boolean> holding0:
                state.holding) {
            boolean o = getNextholding(holding0, actions, state, interm);
            next.holding.add(new ParameterizedVar<Boolean>(holding0.params, o));
        }

        return next;
    }


    private static boolean getNextobject_at(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
String obj_1 = var.params.get(0);
String discrete_location_2 = var.params.get(1);
if (interm.success_pick_unknown && obj_1.equals(actions.get(0)._o2[1]) && discrete_location_2.equals(actions.get(0)._o2[2])) {return false;}
 else if (interm.success_place_unknown && obj_1.equals(actions.get(0)._o2[1]) && discrete_location_2.equals(actions.get(0)._o2[3])) {return true;}
 else   return var.value;
                    
    }

    private static boolean getNextpossible_location(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
    return var.value;
    }

    private static boolean getNextnear(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
String robot_1 = var.params.get(0);
String discrete_location_2 = var.params.get(1);
if (interm.success_robot_navigation && robot_1.equals(actions.get(0)._o2[0]) && discrete_location_2.equals(actions.get(0)._o2[2])) {return true;}
 else if (interm.success_robot_navigation && robot_1.equals(actions.get(0)._o2[0]) && discrete_location_2.equals(actions.get(0)._o2[1])) {return false;}
 else   return var.value;
                    
    }

    private static boolean getNexthand_empty(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
String robot_1 = var.params.get(0);
if (interm.success_pick_unknown && robot_1.equals(actions.get(0)._o2[0])) {return false;}
 else if (interm.success_place_unknown && robot_1.equals(actions.get(0)._o2[0])) {return true;}
 else   return var.value;
        
    }

    private static boolean getNextdoor_is_open(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
String discrete_location_1 = var.params.get(0);
if (interm.success_push_button) {return true;}
 else   return var.value;
        
    }

    private static boolean getNextpickable(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
    return var.value;
    }

    private static boolean getNextholding(ParameterizedVar<Boolean> var, ArrayList<Pair<String,String[]>> actions, MicroStateState state, MicroStateIntermediate interm) {
String robot_1 = var.params.get(0);
String obj_2 = var.params.get(1);
if (interm.success_pick_unknown && robot_1.equals(actions.get(0)._o2[0]) && obj_2.equals(actions.get(0)._o2[1])) {return true;}
 else if (interm.success_place_unknown && robot_1.equals(actions.get(0)._o2[0]) && obj_2.equals(actions.get(0)._o2[1])) {return false;}
 else   return var.value;
                    
    }

    private static boolean getGoal_reached(MicroStateState state, MicroStateIntermediate interm, MicroStateState next, ArrayList<Pair<String, String[]>> actions) {
        if ((next.object_at.stream().filter(x -> x.value && x.params.get(0).equals("can")
 && x.params.get(1).equals("auditorium")
).count() > 0)
&&(next.near.stream().filter(x -> x.value && x.params.get(0).equals("armadillo")
 && x.params.get(1).equals("near_elevator1")
).count() > 0)
)
return true;
        return false;
    }
}
