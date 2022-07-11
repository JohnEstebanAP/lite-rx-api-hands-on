package io.pivotal.literx;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {

//========================================================================================

	// TODO Return an empty Mono
	Mono<String> emptyMono() {

		return Mono.empty();
	}

//========================================================================================

	// TODO Return a Mono that never emits any signal
	Mono<String> monoWithNoSignal() {
		return Mono.just("DATA").never();
	}

//========================================================================================

	// TODO Return a Mono that contains a "foo" value
	Mono<String> fooMono() {
		return Mono.just("foo");
	}

//========================================================================================

	// TODO Create a Mono that emits an IllegalStateException
	Mono<String> errorMono() {

		Mono<String> monoError =  Mono.error(new  IllegalStateException("UN ERROR"));
		return monoError;
	}

}
