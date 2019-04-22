import { Subscription } from 'rxjs';

export abstract class DestructibleComponent {

    private subscriptions: Subscription[] = [];
    protected registerSubscription(subscription: Subscription): Subscription {
        if (subscription) {
            this.subscriptions.push(subscription);
        }
        return subscription;
    }

    protected destroy() {
        this.subscriptions.forEach(s => s.unsubscribe());
    }

    constructor() { }
}
