package com.shroke.util;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Use
 * <pre>
 * LogMessageBuilder builder = new LogMessageBuilder("message")
 *                                 .addParameter("p1", object1)
 *                                 .addParameter("p2", object2);
 * logger.info(builder.getMessagePattern(), builder.getMessageParameters());
 * </pre>
 * or
 * <pre>logger.info(LogMessageBuilder.MESSAGE_HOLDER, new LogMessageBuilder("message")
 *                                                .addParameter("p1", object1)
 *                                                .addParameter("p2", object2));
 * </pre>
 * Avoid
 * <pre>
 * logger.info(new LogMessageBuilder("message")
 *                 .addParameter("p1", object1)
 *                 .addParameter("p2", object2)
 *                 .toString());
 * </pre>
 */
public class LogMessageBuilder {

    public static final String MESSAGE_HOLDER = "{}";
    private static final String ESCAPED_HOLDER = "\\" + MESSAGE_HOLDER;
    private static final Joiner JOINER = Joiner.on(",");
    private static final Function<ParameterEntry, ParameterEntry> TO_PATTERN_FUNCTION = new Function<ParameterEntry, ParameterEntry>() {

        @Override
        public ParameterEntry apply(ParameterEntry from) {
            return new ParameterEntry(escapeBrace(from.getName()), MESSAGE_HOLDER);
        }
    };

    static class ParameterEntry {
        String name;
        Object parameter;

        ParameterEntry(String name, Object parameter) {
            this.name = name;
            this.parameter = parameter;
        }

        public String getName() {
            return name;
        }

        public Object getParameter() {
            return parameter;
        }

        @Override
        public String toString() {
            return name + "=" + parameter;
        }
    }

    private String message;
    private List<ParameterEntry> parameters = Lists.newArrayList();

    public LogMessageBuilder(String message) {
        this.message = StringUtils.trimToEmpty(message);
    }

    public LogMessageBuilder addParameter(String name, Object value) {
        parameters.add(new ParameterEntry(name, value));
        return this;
    }

    public String getMessagePattern() {
        return buildMessage(escapeBrace(message), Lists.transform(parameters, TO_PATTERN_FUNCTION));
    }

    public Object[] getMessageParameters() {
        int size = parameters.size();
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = parameters.get(i).getParameter();
        }
        return result;
    }

    private static String buildMessage(String message, List<ParameterEntry> entries) {
        if (entries.isEmpty()) {
            return message;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(message);
            builder.append(" Parameters: ");
            builder.append(JOINER.join(entries));
            return builder.toString();
        }
    }

    private static String escapeBrace(String message) {
        return StringUtils.replace(message, MESSAGE_HOLDER, ESCAPED_HOLDER);
    }

    @Override
    public String toString() {
        return buildMessage(message, parameters);
    }

}
