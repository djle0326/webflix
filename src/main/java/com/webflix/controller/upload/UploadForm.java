<<<<<<< HEAD
package com.webflix.controller.upload;

public class UploadForm {

}
||||||| empty tree
=======
package com.webflix.controller.upload;

import java.util.Map;

import com.webflix.controller.Controller;

public class UploadForm implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "upload-from";
	}
	
	
}
>>>>>>> 8a2041f9832ee1aef056c9cd9bee8e299cedb51e
