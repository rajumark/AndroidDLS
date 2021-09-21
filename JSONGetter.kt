 


import org.json.JSONArray
import org.json.JSONObject


infix fun Pair<JSONObject, String>?.drgetJSONSInt(function: (Int) -> Unit) {
    if (this != null) {
        if (this.first.has(this.second)) {
            val value = this.first.get(this.second)
            value?.let {
                if (value is Int) {
                    function(value)
                }
            }
        }
    }
}

infix fun String?.drgetJSONObject(function: (JSONObject) -> Unit) {
    if (this != null) {
        try {
            val jsonobj = JSONObject(this)
            function(jsonobj)
        } catch (e: Exception) {
            println("JSONError:" + e.toString())
        }
    }
}

infix fun Pair<JSONObject, String>?.drgetJSONArray(function: (JSONArray) -> Unit) {
    if (this != null) {
        if (this.first.has(this.second)) {
            val jdsa = this.first.get(this.second)
            if (jdsa is JSONArray) {
                function(jdsa)
            }
        }
    }
}

infix fun Pair<JSONObject, String>?.drgetJSONObject(function: (JSONObject) -> Unit) {
    if (this != null) {
        if (this.first.has(this.second)) {
            val jdsa = this.first.get(this.second)
            if (jdsa is JSONObject) {
                function(jdsa)
            }
        }
    }
}

infix fun Pair<JSONObject, String>?.drgetJSONString(function: (String) -> Unit) {
    if (this != null) {
        if (this.first.has(this.second)) {
            val value = this.first.get(this.second)
            value.let {
                when (it) {
                    is String -> if (it != "" && it.trim().isNotEmpty()) {
                        function(it.trim())
                    }
                    else -> if (it != "" && value.toString().trim().isNotEmpty()) {
                        function(it.toString().trim())
                    }
                }
            }
        }
    }
}


infix fun JSONArray.forEachIndexed(f: (Int, JSONObject) -> Unit) {
    (0 until this.length()).forEach { i ->
        f(i, this.getJSONObject(i))
    }
}
infix fun JSONArray.forEach(f: (JSONObject) -> Unit) {
    (0 until this.length()).forEach { i ->
        f(this.getJSONObject(i))
    }
}

