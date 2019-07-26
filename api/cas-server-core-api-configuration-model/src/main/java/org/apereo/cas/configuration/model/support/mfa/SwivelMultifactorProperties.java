package org.apereo.cas.configuration.model.support.mfa;

import java.util.List;

import org.apereo.cas.configuration.support.RequiredProperty;
import org.apereo.cas.configuration.support.RequiresModule;

import lombok.Getter;
import lombok.Setter;

/**
 * This is {@link SwivelMultifactorProperties}.
 *
 * @author Misagh Moayyed
 * @author Robin Withey
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-swivel")
@Getter
@Setter
public class SwivelMultifactorProperties extends BaseMultifactorProviderProperties {
	/**
	 * Provider id by default.
	 */
	public static final String DEFAULT_IDENTIFIER = "mfa-swivel";

	private static final long serialVersionUID = -7409451053833491119L;

	/**
	 * Swivel base endpoint url for verification of credentials.
	 */
	@RequiredProperty
	/**
	 * URL for primary Swivel Sentry server.
	 */
	private String swivelUrl;

	/**
	 * URL for alternative Swivel Sentry server.
	 */
	private String altSwivelUrl;

	/**
	 * Shared secret to authenticate against the swivel server.
	 */
	@RequiredProperty
	private String sharedSecret;

	/**
	 * Control whether SSL errors should be ignored by the swivel server.
	 */
	private boolean ignoreSslErrors;

	/**
	 * The name of the Sentry attribute used by CAS.
	 */
	private String userAttribute;

	/**
	 * Control whether sessionless authentication is allowed
	 */
	private boolean allowSessionlessAuthentication;

	/**
	 * Control whether TURing image authentication is allowed
	 */
	private boolean allowTURing;

	/**
	 * Control whether PINpad authentication is allowed
	 */
	private boolean allowPINpad;

	/**
	 * Control whether Message on demand is allowed
	 */
	private boolean allowMessageOnDemand;

	/**
	 * Control whether Push authentication is allowed
	 */
	private boolean allowPush;

	/**
	 * Control whether Voice (telephony) authentication is allowed
	 */
	private boolean allowVoice;

	/**
	 * Control whether unknown users are required to use Swivel-MFA. A list of
	 * services that must use MFA, or "ALL" if no bypass is allowed.
	 */
	private List<String> bypassUnknownUsers;

	public boolean isAllowVoice() {
		return allowVoice;
	}

	public void setAllowVoice(boolean allowVoice) {
		this.allowVoice = allowVoice;
	}

	/**
	 * Control whether alternative URL is used for voice telephony. If false, and
	 * there is an alternative URL, it will be used for Push, and the primary for
	 * voice telephony.
	 */
	private boolean useAltUrlForVoice;

	public SwivelMultifactorProperties() {
		setId(DEFAULT_IDENTIFIER);
	}

	public String getSwivelUrl() {
		return swivelUrl;
	}

	public void setSwivelUrl(final String swivelUrl) {
		this.swivelUrl = swivelUrl;
	}

	public String getSharedSecret() {
		return sharedSecret;
	}

	public void setSharedSecret(final String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}

	public boolean isIgnoreSslErrors() {
		return ignoreSslErrors;
	}

	public void setIgnoreSslErrors(final boolean ignoreSslErrors) {
		this.ignoreSslErrors = ignoreSslErrors;
	}

	public String getUserAttribute() {
		return userAttribute;
	}

	public void setUserAttribute(String userAttribute) {
		this.userAttribute = userAttribute;
	}

	public boolean isAllowSessionlessAuthentication() {
		return allowSessionlessAuthentication;
	}

	public void setAllowSessionlessAuthentication(boolean allowSessionlessAuthentication) {
		this.allowSessionlessAuthentication = allowSessionlessAuthentication;
	}

	public boolean isAllowTURing() {
		return allowTURing;
	}

	public void setAllowTURing(boolean allowTURing) {
		this.allowTURing = allowTURing;
	}

	public boolean isAllowPINpad() {
		return allowPINpad;
	}

	public void setAllowPINpad(boolean allowPINpad) {
		this.allowPINpad = allowPINpad;
	}

	public boolean isAllowMessageOnDemand() {
		return allowMessageOnDemand;
	}

	public void setAllowMessageOnDemand(boolean allowMessageOnDemand) {
		this.allowMessageOnDemand = allowMessageOnDemand;
	}

	public boolean isAllowPush() {
		return allowPush;
	}

	public void setAllowPush(boolean allowPush) {
		this.allowPush = allowPush;
	}

	public String getAltSwivelUrl() {
		return altSwivelUrl;
	}

	public void setAltSwivelUrl(String altSwivelUrl) {
		this.altSwivelUrl = altSwivelUrl;
	}

	public boolean isUseAltUrlForVoice() {
		return useAltUrlForVoice;
	}

	public void setUseAltUrlForVoice(boolean useAltUrlForVoice) {
		this.useAltUrlForVoice = useAltUrlForVoice;
	}

	public List<String> getBypassUnknownUsers() {
		return bypassUnknownUsers;
	}

	public void setBypassUnknownUsers(List<String> bypassUnknownUsers) {
		this.bypassUnknownUsers = bypassUnknownUsers;
	}
}
