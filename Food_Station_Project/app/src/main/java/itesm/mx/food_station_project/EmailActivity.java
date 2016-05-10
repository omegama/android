package itesm.mx.food_station_project;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by omega on 5/9/2016.
 */
public class EmailActivity extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "http://yamahaqro.com/SQL/mail.php";
    private Map<String, String> params;

    public EmailActivity(String msg, Response.Listener<String> listener){
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("msg", msg);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
