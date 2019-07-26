package org.apereo.cas.adaptors.swivel;

import org.apache.commons.lang3.StringUtils;
import org.apereo.cas.authentication.AbstractMultifactorAuthenticationProvider;
import org.apereo.cas.configuration.model.support.mfa.SwivelMultifactorProperties;
import org.apereo.cas.services.RegisteredService;

import com.swivelsecure.swivelclient.SwivelClient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This is {@link SwivelMultifactorAuthenticationProvider}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class SwivelMultifactorAuthenticationProvider extends AbstractMultifactorAuthenticationProvider {
	private static final long serialVersionUID = 498455080794156917L;

	private String swivelUrl;
	private boolean ignoreCertErrors;

	@Override
	public boolean isAvailable(final RegisteredService service) {
		return canPing();
	}

	@Override
	public String getFriendlyName() {
		return "Swivel Secure";
	}

	@Override
	public String getId() {
		return StringUtils.defaultIfBlank(super.getId(), SwivelMultifactorProperties.DEFAULT_IDENTIFIER);
	}

	/**
	 * Can ping provider?
	 *
	 * @return the boolean
	 */
	public boolean canPing() {
		try {
			SwivelClient client = new SwivelClient();
			client.setUrlString(swivelUrl);
			client.setSelfSigned(ignoreCertErrors);
			boolean result = client.ping();
			return result;
		} catch (final Exception e) {
			log.warn(e.getMessage(), e);
		}
		return false;
	}
}