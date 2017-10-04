package com;

import java.io.Serializable;

public interface Message extends Serializable {
    long serialVersionUID=1L;
    Message performAction();
}
