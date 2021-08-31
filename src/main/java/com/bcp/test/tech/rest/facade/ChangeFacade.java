package com.bcp.test.tech.rest.facade;

import com.bcp.test.tech.domain.models.ChangeModel;
import com.bcp.test.tech.domain.rr.request.ChangeRequest;
import rx.Single;

public interface ChangeFacade {

    Single<ChangeModel> findById(final Long id);

    Single<ChangeModel> register(final ChangeRequest request);

}
