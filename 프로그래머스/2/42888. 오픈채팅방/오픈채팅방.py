def solution(record):
    answer = []
    dic = {}

    for s in record:
        s_split = s.split()
        if len(s_split) == 3:
            dic[s_split[1]] = s_split[2]
    
    for s in record:
        s_split = s.split()
        if s_split[0] == 'Enter':
            answer.append('%s님이 들어왔습니다.' %dic[s_split[1]])
        elif s_split[0] == 'Leave':
            answer.append('%s님이 나갔습니다.' %dic[s_split[1]])

    return answer