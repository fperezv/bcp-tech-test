package com.bcp.test.tech.domain.rr.request.assembler;

import com.bcp.test.tech.domain.models.ChangeModel;
import com.bcp.test.tech.domain.rr.request.ChangeRequest;
import com.bcp.test.tech.utils.CheckerUtils;
import com.bcp.test.tech.utils.DateUtils;
import com.bcp.test.tech.utils.FunctionUtils;

public final class ChangeRequestAssembler {

    public static ChangeModel toModel(final ChangeRequest request) {
        CheckerUtils.notEmpty(request.getAmount(), ChangeRequest.Fields.amount);
        CheckerUtils.notEmpty(request.getOriginCoin(), ChangeRequest.Fields.originCoin);
        CheckerUtils.notEmpty(request.getDestinationCoin(), ChangeRequest.Fields.destinationCoin);
        return ChangeModel.builder()
                .amount(request.getAmount())
                .in(FunctionUtils.iif(request.getIn(), true))
                .longDate(FunctionUtils.iif(request.getDate(), DateUtils.now().getTime()))
                .build();
    }

}
