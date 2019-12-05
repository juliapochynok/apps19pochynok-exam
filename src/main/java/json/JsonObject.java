package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private JsonPair[] jsonPairs;
    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = jsonPairs;
    }

//    public JsonObject(JsonPair... jsonPairs) {
//        int i = 0;
//        for (JsonPair el: jsonPairs) {
//            if (this.jsonPairs.length != 0){
//                for (JsonPair elA : this.jsonPairs) {
//                    if (el.key.equals(elA.key)) {
//                        elA = elA;
//                    } else {
//                        this.jsonPairs[i] = el;
//                        i++;
//                    }
//                }
//            }
//        }
//        this.jsonPairs = jsonPairs;
//    }

    @Override
    public String toJson() {
        String finalStr = "{";
        for (int i = 0; i < jsonPairs.length; i++) {
            String name = jsonPairs[i].key;
            String value = jsonPairs[i].value.toJson();
            finalStr += "'" + name + "': " + value;
            if (i != jsonPairs.length - 1){ finalStr += ", "; }
        }
        finalStr += "}";
        return finalStr;
    }

    public void add(JsonPair jsonPair) {
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
