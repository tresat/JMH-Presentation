package com.tomtresansky.benchmark;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import com.google.common.base.Preconditions;

import ucs.ucms.shared.universal.util.model.ModelVerifier;
import ucs.ucmsbase.shared.universal.datamodel.shared.abstractdm.appearance.DMAbstractAppearance;
import ucs.ucmsbase.shared.universal.datamodel.shared.abstractdm.docket.DMAbstractDocket;
import ucs.ucmsbase.shared.universal.datamodel.shared.abstractdm.docket.DMAbstractDocketPath;

@State(Scope.Thread)
public class ModelVerifierBenchmarks {
  DMAbstractDocket docket;
  
  @Setup
  public void setup() {
    docket = new DMAbstractDocket();
    docket.setDocketId(BigDecimal.valueOf(12020l));
    
    DMAbstractAppearance app1 = new DMAbstractAppearance();
    app1.setAppearanceId(BigDecimal.valueOf(3904));
    app1.setAppearanceDate(Calendar.getInstance());
    docket.getAppearance().add(app1);

    DMAbstractAppearance app2 = new DMAbstractAppearance();
    app2.setAppearanceId(BigDecimal.valueOf(1234314));
    app2.setAppearanceDate(Calendar.getInstance());
    docket.getAppearance().add(app2);
  }
  
  @Benchmark
  public void model_verifier(Blackhole blackhole) {
    ModelVerifier.forPaths(
        DMAbstractDocketPath.origin().getDocketId(),
        DMAbstractDocketPath.origin().getAppearance(0),
        DMAbstractDocketPath.origin().getAppearance().getAppearanceId(),
        DMAbstractDocketPath.origin().getAppearance().getAppearanceDate()
    ).checkSet(docket);
    
    blackhole.consume(docket);
    blackhole.consume(docket.getDocketId());
    blackhole.consume(docket.getAppearance());
    blackhole.consume(docket.getAppearance().get(0));
    blackhole.consume(docket.getAppearance().get(0).getAppearanceId());
    blackhole.consume(docket.getAppearance().get(0).getAppearanceDate());
  }
  
  @Benchmark
  public void defined_checks(Blackhole blackhole) {
    Objects.requireNonNull(docket, "docket can NOT be null!");
    Objects.requireNonNull(docket.getDocketId(), "docket.DOCKET_ID can NOT be null!");
    Preconditions.checkArgument(!docket.getAppearance().isEmpty(), "docket.appearance[] can NOT be empty!");
    for (DMAbstractAppearance appearance : docket.getAppearance()) {
      Objects.requireNonNull(appearance, "appearance can NOT be null!");
      Objects.requireNonNull(appearance.getAppearanceId(), "appearance.APPEARANCE_ID can NOT be null!");
      Objects.requireNonNull(appearance.getAppearanceDate(), "appearance.APPEARANCE_DATE can NOT be null!");
    }

    blackhole.consume(docket);
    blackhole.consume(docket.getDocketId());
    blackhole.consume(docket.getAppearance());
    blackhole.consume(docket.getAppearance().get(0));
    blackhole.consume(docket.getAppearance().get(0).getAppearanceId());
    blackhole.consume(docket.getAppearance().get(0).getAppearanceDate());
  }
  
  @Benchmark
  public void baseline(Blackhole blackhole) {
    blackhole.consume(docket);
    blackhole.consume(docket.getDocketId());
    blackhole.consume(docket.getAppearance());
    blackhole.consume(docket.getAppearance().get(0));
    blackhole.consume(docket.getAppearance().get(0).getAppearanceId());
    blackhole.consume(docket.getAppearance().get(0).getAppearanceDate());
  }
}
