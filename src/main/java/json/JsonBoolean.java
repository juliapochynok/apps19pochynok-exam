package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */

public class JsonBoolean extends Json {

    private final Boolean bools;

    public JsonBoolean(Boolean bool) {
        this.bools = bool;
    }


    @Override
    public String toJson() {
        return bools.toString();
    }
}
