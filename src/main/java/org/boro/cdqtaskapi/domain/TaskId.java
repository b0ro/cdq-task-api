package org.boro.cdqtaskapi.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class TaskId {
    int raw;
}
