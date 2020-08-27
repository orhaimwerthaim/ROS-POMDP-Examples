package JavaSim2POMCP.POMCP.JavaGeneratos.Generated;

public class MicroStateObservation
{
    public boolean goal_reached;
    public boolean invalid_action_observation;
    public int obsrv_push_button;
    public int obsrv_robot_navigation;
    public int obsrv_pick_unknown;
    public int obsrv_sense_object;
    public int obsrv_place_unknown;



    public MicroStateObservation()
    {
        this(false);
    }

    public MicroStateObservation(boolean IsObservationForInvalidAction)
    {
        if(IsObservationForInvalidAction)
        {
            invalid_action_observation=true;
        }
    }
    @Override
    public String toString() {
        return "goal_reached:" + goal_reached + " | " +
                "invalid_action_observation:" + invalid_action_observation + " | " +
                "obsrv_push_button:" + obsrv_push_button + " | " +
                "obsrv_robot_navigation:" + obsrv_robot_navigation + " | " +
                "obsrv_pick_unknown:" + obsrv_pick_unknown + " | " +
                "obsrv_sense_object:" + obsrv_sense_object + " | " +
                "obsrv_place_unknown:" + obsrv_place_unknown;
    }
}
