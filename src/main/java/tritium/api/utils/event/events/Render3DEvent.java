package tritium.api.utils.event.events;

import tritium.api.utils.event.api.events.Event;

public class Render3DEvent implements Event {

	private float partialTicks;

	public Render3DEvent(final float partialTicks) {
		this.partialTicks = partialTicks;
	}

	public float getPartialTicks() {
		return partialTicks;
	}
}
