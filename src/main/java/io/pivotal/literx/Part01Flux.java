package io.pivotal.literx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

	public static Logger log = LoggerFactory.getLogger(Part01Flux.class);
//========================================================================================

	// TODO Return an empty Flux
	Flux<String> emptyFlux() {

		return Flux.empty();
	}

//========================================================================================

	// TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
	Flux<String> fooBarFluxFromValues() {
		Flux<String> towdata = Flux.just("foo", "bar");
		return towdata ;
	}

//========================================================================================

	// TODO Create a Flux from a List that contains 2 values "foo" and "bar"
	Flux<String> fooBarFluxFromList() {
		List<String> data = new ArrayList<>();
		data.add("foo");
		data.add("bar");

		return Flux.fromIterable(data);
	}

//========================================================================================

	// TODO Create a Flux that emits an IllegalStateException
	Flux<String> errorFlux() {
		List<String> data = new ArrayList<>();
		data.add("foo");
		data.add("bar");

		Flux<String> fluxError =  Flux.error(new  IllegalStateException("UN ERROR"));

		return fluxError;
	}

//========================================================================================

	// TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
	Flux<Long> counter() {
		Flux<Long>  counterIncrement = Flux.range(0,10).map(num -> new Long(num)).interval(Duration.ofMillis(100)).take(10);
		counterIncrement.map(x -> x).subscribe(x -> log.info(x.toString()));
		return counterIncrement;
	}

}
