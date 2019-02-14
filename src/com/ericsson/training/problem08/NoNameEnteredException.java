package com.ericsson.training.problem08;
/**
 * NoNameEnteredException for throwing a CheckedException.
 * @author ezaksch
 *
 */
public class NoNameEnteredException extends Exception {
	public NoNameEnteredException(String name) {
		super(name);
	}
}
