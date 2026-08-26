interface StatusProvider {
    getStatus(): string;
}

abstract class BaseService {
    protected serviceName: string;

    constructor(serviceName: string) {
        this.serviceName = serviceName;
    }

    abstract info(): string;
}

class ApiService extends BaseService implements StatusProvider {
    private active: boolean = true;

    public getStatus(): string {
        return this.active ? "ACTIVE" : "PASSIVE";
    }

    public info(): string {
        return `${this.serviceName}: ${this.getStatus()}`;
    }
}

const service = new ApiService("Week6 API");
console.log(service.info());
