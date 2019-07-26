package org.apereo.cas.adaptors.swivel.web.flow.rest;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apereo.cas.configuration.model.support.mfa.SwivelMultifactorProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swivelsecure.swivelclient.SwivelClient;

/**
 * This is {@link SwivelTuringImageGeneratorController}.
 *
 * @author Misagh Moayyed
 * @author Robin Withey
 * @since 5.2.0
 */
@RestController
public class SwivelTuringImageGeneratorController extends AbstractSwivelController {

	public SwivelTuringImageGeneratorController(SwivelMultifactorProperties props) {
		super(props);
	}

	/**
	 * Generate. Requests a TURing image.
	 *
	 * @param response the response. A TURing image is written to the response.
	 * @param request  the request. Should contain the parameter "principal".
	 * @throws Exception the exception
	 */
	@GetMapping("/swivel/turingImage")
	public void generate(final HttpServletResponse response, final HttpServletRequest request) throws Exception {
		response.setContentType("image/jpeg");
		final String principal = request.getParameter("principal");
		if (StringUtils.isBlank(principal)) {
			throw new IllegalArgumentException("No principal is specified in the turing image request");
		}
		generateImageByUsername(response.getOutputStream(), principal);
	}

	private void generateImageByUsername(final OutputStream stream, final String principal) {
		try {
			SwivelClient client = getClient();
			byte[] imageBytes = client.sendImageRequestByUsername(principal);
			stream.write(imageBytes);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
