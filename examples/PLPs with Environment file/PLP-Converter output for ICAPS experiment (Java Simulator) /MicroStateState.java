package JavaSim2POMCP.POMCP.JavaGeneratos.Generated;

import JavaSim2POMCP.POMCP.JavaGeneratos.fixed.ParameterizedVar;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MicroStateState{
    public ArrayList<ParameterizedVar<Boolean>> object_at;
    public ArrayList<ParameterizedVar<Boolean>> possible_location;
    public ArrayList<ParameterizedVar<Boolean>> near;
    public ArrayList<ParameterizedVar<Boolean>> hand_empty;
    public ArrayList<ParameterizedVar<Boolean>> door_is_open;
    public ArrayList<ParameterizedVar<Boolean>> pickable;
    public ArrayList<ParameterizedVar<Boolean>> holding;
    public MicroStateState()
    {
        object_at = new ArrayList<>();
        possible_location = new ArrayList<>();
        near = new ArrayList<>();
        hand_empty = new ArrayList<>();
        door_is_open = new ArrayList<>();
        pickable = new ArrayList<>();
        holding = new ArrayList<>();
    }

    @Override
    public String toString() {
        String s_object_at = object_at.stream().filter(x-> x.value).map(x-> "object_at" + x.toString())
                .collect(Collectors.joining(","));

        String s_possible_location = possible_location.stream().filter(x-> x.value).map(x-> "possible_location" + x.toString())
                .collect(Collectors.joining(","));

        String s_near = near.stream().filter(x-> x.value).map(x-> "near" + x.toString())
                .collect(Collectors.joining(","));

        String s_hand_empty = hand_empty.stream().filter(x-> x.value).map(x-> "hand_empty" + x.toString())
                .collect(Collectors.joining(","));

        String s_door_is_open = door_is_open.stream().filter(x-> x.value).map(x-> "door_is_open" + x.toString())
                .collect(Collectors.joining(","));

        String s_pickable = pickable.stream().filter(x-> x.value).map(x-> "pickable" + x.toString())
                .collect(Collectors.joining(","));

        String s_holding = holding.stream().filter(x-> x.value).map(x-> "holding" + x.toString())
                .collect(Collectors.joining(","));

        return s_object_at + " | " + s_possible_location + " | " + s_near + " | " + s_hand_empty + " | " + s_door_is_open + " | " + s_pickable + " | " + s_holding;
    }
}
