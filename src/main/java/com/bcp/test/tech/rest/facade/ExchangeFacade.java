package com.bcp.test.tech.rest.facade;

import com.bcp.test.tech.domain.models.ExchangeModel;
import com.bcp.test.tech.domain.rr.request.ExchangeRequest;
import rx.Single;

public interface ExchangeFacade {

    Single<ExchangeModel> exchange(final ExchangeRequest request);

}
